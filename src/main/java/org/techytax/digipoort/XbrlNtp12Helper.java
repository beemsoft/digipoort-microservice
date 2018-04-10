package org.techytax.digipoort;

import nl.nltaxonomie.nt12.bd._20171213.dictionary.bd_codes.ContactItemType;
import nl.nltaxonomie.nt12.bd._20171213.dictionary.bd_types.Anstring10VItemType;
import nl.nltaxonomie.nt12.bd._20171213.dictionary.bd_types.Anstring14VItemType;
import nl.nltaxonomie.nt12.bd._20171213.dictionary.bd_types.Anstring200VItemType;
import nl.nltaxonomie.nt12.bd._20171213.dictionary.bd_types.Anstring20VItemType;
import nl.nltaxonomie.nt12.bd._20171213.dictionary.bd_types.Anstring30VItemType;
import nl.nltaxonomie.nt12.bd._20171213.dictionary.bd_types.Anstring8FItemType;
import nl.nltaxonomie.nt12.bd._20171213.dictionary.bd_types.DateTimeItemType;
import nl.nltaxonomie.nt12.bd._20171213.dictionary.bd_types.MonetaryNoDecimals10VItemType;
import nl.nltaxonomie.nt12.bd._20171213.dictionary.bd_types.MonetaryNoDecimals9VItemType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.techytax.domain.FiscalPeriod;
import org.techytax.domain.User;
import org.techytax.domain.VatDeclarationData;
import org.techytax.domain.VatPeriodType;
import org.techytax.util.DateHelper;
import org.techytax.util.VersionHelper;
import org.xbrl._2003.instance.Context;
import org.xbrl._2003.instance.ContextEntityType;
import org.xbrl._2003.instance.ContextEntityType.Identifier;
import org.xbrl._2003.instance.ContextPeriodType;
import org.xbrl._2003.instance.ObjectFactory;
import org.xbrl._2003.instance.Unit;
import org.xbrl._2003.instance.Xbrl;
import org.xbrl._2003.xlink.SimpleType;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class XbrlNtp12Helper {

	private static final String CONTEXT_ID = "Msg";
	private static final String ISO_EURO = "iso4217:EUR";
	private static final String UNIT_ID = "u0";
	private static final String DECIMALS_TYPE = "INF";
	private static final String PACKAGE_VERSION = VersionHelper.getXbrlVersion();
	private static final String PACKAGE_NAME = "TechyTax";
	private static final String BELASTING_PLICHTIGE = "BPL";
	private static final String TEST_FISCAL_NUMBER = "001000045B93";

	@Resource
	private Environment environment;

	public static String createXbrlInstance(VatDeclarationData vatDeclarationData) {
		ObjectFactory xbrlObjectFactory;
		JAXBContext jc;
		Marshaller m;
		try {
			xbrlObjectFactory = new ObjectFactory();
			jc = JAXBContext.newInstance(ObjectFactory.class,
					nl.nltaxonomie.nt12.bd._20171213_b.dictionary.bd_types.ObjectFactory.class, org.xbrl._2006.xbrldi.ObjectFactory.class, org.xbrl._2003.xlink.ObjectFactory.class,
					nl.nltaxonomie._2011.xbrl.xbrl_syntax_extension.ObjectFactory.class, org.xbrl._2003.linkbase.ObjectFactory.class, org.xbrl._2005.xbrldt.ObjectFactory.class,
					nl.nltaxonomie.nt12.bd._20171213_b.dictionary.bd_domain_members.ObjectFactory.class,
					nl.nltaxonomie.iso.iso4217.ObjectFactory.class,
					nl.nltaxonomie.nt12.bd._20171213_b.dictionary.bd_data.ObjectFactory.class);
			m = jc.createMarshaller();
			StringWriter writer = new StringWriter();
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			Xbrl xbrl = xbrlObjectFactory.createXbrl();

			org.xbrl._2003.xlink.ObjectFactory xlinkObjectFactory = new org.xbrl._2003.xlink.ObjectFactory();
			SimpleType simpleType = xlinkObjectFactory.createSimpleType();
			simpleType.setType("simple");
			simpleType.setHref("http://www.nltaxonomie.nl/nt12/bd/20171213/entrypoints/bd-rpt-ob-aangifte-2018.xsd");
			xbrl.getSchemaRef().add(simpleType);
			xbrl.getOtherAttributes().put(new QName("xml:lang"), "nl");

			Context context = xbrlObjectFactory.createContext();
			context.setId(CONTEXT_ID);

			ContextEntityType contextEntityType = xbrlObjectFactory.createContextEntityType();
			Identifier identifier = xbrlObjectFactory.createContextEntityTypeIdentifier();
			identifier.setScheme("www.belastingdienst.nl/omzetbelastingnummer");
			identifier.setValue(vatDeclarationData.getFiscalNumber());
			ContextPeriodType period = xbrlObjectFactory.createContextPeriodType();
			period.setStartDate(vatDeclarationData.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			period.setEndDate(vatDeclarationData.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			contextEntityType.setIdentifier(identifier);
			context.setEntity(contextEntityType);
			context.setPeriod(period);
			xbrl.getItemOrTupleOrContext().add(context);

			Unit unit = xbrlObjectFactory.createUnit();
			unit.setId(UNIT_ID);
			QName qName = new QName(ISO_EURO);
			unit.getMeasure().add(qName);
			xbrl.getItemOrTupleOrContext().add(unit);

			nl.nltaxonomie.nt12.bd._20171213.dictionary.bd_types.ObjectFactory bdTypeObjectFactory = new nl.nltaxonomie.nt12.bd._20171213.dictionary.bd_types.ObjectFactory();
			nl.nltaxonomie.nt12.bd._20171213.dictionary.bd_data.ObjectFactory bdDataObjectFactory = new nl.nltaxonomie.nt12.bd._20171213.dictionary.bd_data.ObjectFactory();
			ContactItemType contactType = new ContactItemType();
			contactType.setValue(BELASTING_PLICHTIGE);
			contactType.setContextRef(context);
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createContactType(contactType));

			Anstring10VItemType initials = bdTypeObjectFactory.createAnstring10VItemType();
			initials.setValue(vatDeclarationData.getInitials());
			initials.setContextRef(context);
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createContactInitials(initials));

			if (StringUtils.isNotEmpty(vatDeclarationData.getPrefix())) {
				Anstring10VItemType prefix = bdTypeObjectFactory.createAnstring10VItemType();
				prefix.setValue(vatDeclarationData.getPrefix());
				prefix.setContextRef(context);
				xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createContactPrefix(prefix));
			}

			Anstring200VItemType surname = bdTypeObjectFactory.createAnstring200VItemType();
			surname.setValue(vatDeclarationData.getSurname());
			surname.setContextRef(context);
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createContactSurname(surname));

			Anstring14VItemType telephoneNumber = bdTypeObjectFactory.createAnstring14VItemType();
			telephoneNumber.setValue(vatDeclarationData.getPhoneNumber());
			telephoneNumber.setContextRef(context);
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createContactTelephoneNumber(telephoneNumber));

			DateTimeItemType dateTime = bdTypeObjectFactory.createDateTimeItemType();
			dateTime.setValue(DateHelper.getTimeStamp(new Date()));
			dateTime.setContextRef(context);
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createDateTimeCreation(dateTime));

			Anstring20VItemType supplier = bdTypeObjectFactory.createAnstring20VItemType();
			supplier.setValue("OB-TechyTax-Ref-1");
			supplier.setContextRef(context);
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createMessageReferenceSupplierVAT(supplier));

			Anstring20VItemType packageVersion = bdTypeObjectFactory.createAnstring20VItemType();
//			packageVersion.setValue(PACKAGE_VERSION);
			packageVersion.setValue("3.0");
			packageVersion.setContextRef(context);
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createSoftwarePackageVersion(packageVersion));

			Anstring30VItemType packageName = bdTypeObjectFactory.createAnstring30VItemType();
			packageName.setValue(PACKAGE_NAME);
			packageName.setContextRef(context);
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createSoftwarePackageName(packageName));

			String softwareVendorAccountNumber = "SWO01088"; // environment.getProperty("software.vendor.account.number");
			Anstring8FItemType softwareVendor = bdTypeObjectFactory.createAnstring8FItemType();
			softwareVendor.setValue(softwareVendorAccountNumber);
			softwareVendor.setContextRef(context);
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createSoftwareVendorAccountNumber(softwareVendor));

			MonetaryNoDecimals10VItemType valueAddedTaxOnInput = bdTypeObjectFactory.createMonetaryNoDecimals10VItemType();
			valueAddedTaxOnInput.setDecimals(DECIMALS_TYPE);
			valueAddedTaxOnInput.setContextRef(context);
			valueAddedTaxOnInput.setUnitRef(unit);
			valueAddedTaxOnInput.setValue(vatDeclarationData.getValueAddedTaxOnInput());
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createValueAddedTaxOnInput(valueAddedTaxOnInput));

			MonetaryNoDecimals10VItemType valueAddedTaxOwed = bdTypeObjectFactory.createMonetaryNoDecimals10VItemType();
			valueAddedTaxOwed.setDecimals(DECIMALS_TYPE);
			valueAddedTaxOwed.setContextRef(context);
			valueAddedTaxOwed.setUnitRef(unit);
			valueAddedTaxOwed.setValue(vatDeclarationData.getValueAddedTaxOwed());
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createValueAddedTaxOwed(valueAddedTaxOwed));

			MonetaryNoDecimals9VItemType valueAddedTaxOwedToBePaidBack = bdTypeObjectFactory.createMonetaryNoDecimals9VItemType();
			valueAddedTaxOwedToBePaidBack.setDecimals(DECIMALS_TYPE);
			valueAddedTaxOwedToBePaidBack.setContextRef(context);
			valueAddedTaxOwedToBePaidBack.setUnitRef(unit);
			valueAddedTaxOwedToBePaidBack.setValue(vatDeclarationData.getValueAddedTaxOwedToBePaidBack());
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createValueAddedTaxOwedToBePaidBack(valueAddedTaxOwedToBePaidBack));

			MonetaryNoDecimals9VItemType valueAddedTaxPrivateUse = bdTypeObjectFactory.createMonetaryNoDecimals9VItemType();
			valueAddedTaxPrivateUse.setDecimals(DECIMALS_TYPE);
			valueAddedTaxPrivateUse.setContextRef(context);
			valueAddedTaxPrivateUse.setUnitRef(unit);
			valueAddedTaxPrivateUse.setValue(vatDeclarationData.getValueAddedTaxPrivateUse());
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createValueAddedTaxPrivateUse(valueAddedTaxPrivateUse));

			MonetaryNoDecimals9VItemType valueAddedTaxSuppliesServicesGeneralTariff = bdTypeObjectFactory.createMonetaryNoDecimals9VItemType();
			valueAddedTaxSuppliesServicesGeneralTariff.setDecimals(DECIMALS_TYPE);
			valueAddedTaxSuppliesServicesGeneralTariff.setContextRef(context);
			valueAddedTaxSuppliesServicesGeneralTariff.setUnitRef(unit);
			valueAddedTaxSuppliesServicesGeneralTariff.setValue(vatDeclarationData.getValueAddedTaxSuppliesServicesGeneralTariff());
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createValueAddedTaxSuppliesServicesGeneralTariff(valueAddedTaxSuppliesServicesGeneralTariff));

			MonetaryNoDecimals10VItemType turnoverSuppliesServicesGenerallTariff = bdTypeObjectFactory.createMonetaryNoDecimals10VItemType();
			turnoverSuppliesServicesGenerallTariff.setDecimals(DECIMALS_TYPE);
			turnoverSuppliesServicesGenerallTariff.setContextRef(context);
			turnoverSuppliesServicesGenerallTariff.setUnitRef(unit);
			turnoverSuppliesServicesGenerallTariff.setValue(vatDeclarationData.getTaxedTurnoverSuppliesServicesGeneralTariff());
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createTaxedTurnoverSuppliesServicesGeneralTariff(turnoverSuppliesServicesGenerallTariff));
			
			MonetaryNoDecimals10VItemType turnoverFromTaxedSuppliesFromCountriesWithinTheEC = bdTypeObjectFactory.createMonetaryNoDecimals10VItemType();
			turnoverFromTaxedSuppliesFromCountriesWithinTheEC.setDecimals(DECIMALS_TYPE);
			turnoverFromTaxedSuppliesFromCountriesWithinTheEC.setContextRef(context);
			turnoverFromTaxedSuppliesFromCountriesWithinTheEC.setUnitRef(unit);
			turnoverFromTaxedSuppliesFromCountriesWithinTheEC.setValue(vatDeclarationData.getTurnoverFromTaxedSuppliesFromCountriesWithinTheEC());			
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createTurnoverFromTaxedSuppliesFromCountriesWithinTheEC(turnoverFromTaxedSuppliesFromCountriesWithinTheEC));

			MonetaryNoDecimals9VItemType valueAddedTaxOnSuppliesFromCountriesOutsideTheEC = bdTypeObjectFactory.createMonetaryNoDecimals9VItemType();
			valueAddedTaxOnSuppliesFromCountriesOutsideTheEC.setDecimals(DECIMALS_TYPE);
			valueAddedTaxOnSuppliesFromCountriesOutsideTheEC.setContextRef(context);
			valueAddedTaxOnSuppliesFromCountriesOutsideTheEC.setUnitRef(unit);
			valueAddedTaxOnSuppliesFromCountriesOutsideTheEC.setValue(BigDecimal.ZERO);
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createValueAddedTaxOnSuppliesFromCountriesOutsideTheEC(valueAddedTaxOnSuppliesFromCountriesOutsideTheEC));

			MonetaryNoDecimals9VItemType valueAddedTaxOnSuppliesFromCountriesWithinTheEC = bdTypeObjectFactory.createMonetaryNoDecimals9VItemType();
			valueAddedTaxOnSuppliesFromCountriesWithinTheEC.setDecimals(DECIMALS_TYPE);
			valueAddedTaxOnSuppliesFromCountriesWithinTheEC.setContextRef(context);
			valueAddedTaxOnSuppliesFromCountriesWithinTheEC.setUnitRef(unit);
			valueAddedTaxOnSuppliesFromCountriesWithinTheEC.setValue(vatDeclarationData.getValueAddedTaxOnSuppliesFromCountriesWithinTheEC());
			xbrl.getItemOrTupleOrContext().add(bdDataObjectFactory.createValueAddedTaxOnSuppliesFromCountriesWithinTheEC(valueAddedTaxOnSuppliesFromCountriesWithinTheEC));

			m.marshal(xbrl, writer);

			System.out.println(writer.toString());
			return writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public static void main(String[] args) throws Exception {
		XbrlNtp12Helper xbrlNtp12Helper = new XbrlNtp12Helper();
//		MockEnvironment environment = new MockEnvironment();
//		environment.setProperty("software.vendor.account.number", "123");
//		xbrlNtp9Helper.environment = environment;
		xbrlNtp12Helper.createTestXbrlInstance();
	}

	private String createTestXbrlInstance() throws Exception {
		User user = new User();
		user.setFiscalNumber(TEST_FISCAL_NUMBER);
		user.setInitials("A.");
		user.setSurname("Tester");
		user.setPhoneNumber("12345678");
		VatDeclarationData vatDeclarationData = new VatDeclarationData();
		FiscalPeriod period = DateHelper.getLatestVatPeriod(VatPeriodType.PER_QUARTER);
		vatDeclarationData.setStartDate(period.getBeginDate());
		vatDeclarationData.setEndDate(period.getEndDate());

		return createXbrlInstance(vatDeclarationData);
	}
}
