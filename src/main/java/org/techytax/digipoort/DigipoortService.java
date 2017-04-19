package org.techytax.digipoort;

import org.techytax.domain.VatDeclarationData;
import org.techytax.ws.AanleverResponse;
import org.techytax.ws.AanleverServiceFault;
import org.techytax.ws.GetBerichtsoortenResponse;
import org.techytax.ws.GetNieuweStatussenProcesResponse;
import org.techytax.ws.GetNieuweStatussenResponse;
import org.techytax.ws.GetProcessenResponse;
import org.techytax.ws.GetStatussenProcesResponse;
import org.techytax.wus.status.StatusinformatieServiceFault;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Voor het (geautomatiseerd, bijv. via regelmatige „polling‟) ophalen van
 * statussen heeft de „getStatussenProces‟-request de voorkeur. Aan het verzoek
 * dient de periode, waarover statussen worden opgevraagd, te worden meegeven om
 * te voorkomen dat veel te veel resultaten worden teruggegeven. Het
 * „tijdstempelVanaf‟ is dan bijvoorbeeld afgeleid van het „tijdstempelTot‟ uit
 * de voorgaande request. Voordeel van deze methode is dat alle statussen uit
 * die periode worden teruggegeven. Bij gebruik van de
 * „getNieuweStatussenProces‟-request worden slechts statussen teruggegeven die
 * niet als reeds opgevraagd zijn gemarkeerd. Hierbij bestaat de mogelijkheid
 * dat deze statussen weliswaar zijn opgevraagd, maar niet daadwerkelijk zijn
 * gezien. De opvrager loopt daarmee het risico dergelijke statussen überhaupt
 * niet meer te zien te krijgen (tenzij alsnog de „getStatussenProces‟-request
 * wordt uitgevoerd).
 * 
 * @author hans
 * 
 */
public interface DigipoortService {

	/**
	 * De Aanleverservice stelt vast of een „aanleververzoek‟ van een
	 * aanleverende partij voldoet aan de koppelvlakspecificatie „WUS 2.0 voor
	 * Bedrijven‟. Indien het aanleververzoek voldoet aan de specificaties, dan
	 * start de Aanleverservice een nieuw verwerkingsproces met een uniek
	 * kenmerk (kenmerk). De Aanleverservice geeft in een synchroon proces
	 * antwoord op deze aanlevering. Dit antwoord bestaat uit de melding dat de
	 * aanlevering is gelukt en het kenmerk van deze aanlevering (SOAP response)
	 * of uit de melding dat de aanlevering is mislukt (SOAP fault). Wanneer de
	 * aanlevering succesvol is, stuurt de Aanleverservice het betreffende
	 * aanleverbericht naar het onderliggende verwerkingsproces.
	 * @return
	 * @throws GeneralSecurityException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws AanleverServiceFault 
	 */
	AanleverResponse aanleveren(String xbrlInstance, String fiscalNumber) throws IOException, GeneralSecurityException, AanleverServiceFault;

	/**
	 * Geeft alle statussen voor de belanghebbende die nog niet eerder bij dit
	 * certificaat opgehaald zijn (alle statussen waarmee voor de betreffende
	 * identiteitBelanghebbende en het meegegeven certificaat nog geen relatie
	 * is vastgelegd).
	 * @param vatDeclarationData
	 * 
	 * @return
	 * @throws IOException 
	 * @throws GeneralSecurityException 
	 */
	GetNieuweStatussenResponse getNieuweStatussen(
    VatDeclarationData vatDeclarationData) throws IOException, GeneralSecurityException;

	/**
	 * Geeft van een bepaald verwerkingsproces alle statussen terug die nog niet
	 * eerder zijn opgevraagd. Het criterium hierbij is: de statussen zijn niet
	 * eerder opgevraagd middels een verzoek waarbij een specifiek certificaat
	 * is gebruikt (alle statussen worden teruggegeven waarbij voor het
	 * betreffende kenmerk en het meegegeven certificaat nog geen relatie is
	 * vastgelegd). Er kan desgewenst ook een tijdsperiode worden meegegeven.
	 * @param vatDeclarationData
	 * @param kenmerk
	 * 
	 * @return
	 * @throws GeneralSecurityException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	GetNieuweStatussenProcesResponse getNieuweStatussenProces(
    VatDeclarationData vatDeclarationData, String kenmerk) throws IOException, GeneralSecurityException;

	/**
	 * Geeft alle processen voor een bepaalde belanghebbende met een specifieke
	 * berichtsoort.
	 * @param vatDeclarationData
	 * 
	 * @return
	 * @throws GeneralSecurityException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws StatusinformatieServiceFault 
	 */
	GetProcessenResponse getProcessen(
    VatDeclarationData vatDeclarationData) throws IOException, GeneralSecurityException, StatusinformatieServiceFault;

	/**
	 * Geeft alle statussen die bij een bepaald verwerkingsproces horen. Er kan
	 * een tijdsperiode worden opgegeven.
	 * @param vatDeclarationData
	 * @param kenmerk
	 * 
	 * @return
	 * @throws GeneralSecurityException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws StatusinformatieServiceFault 
	 */
	GetStatussenProcesResponse getStatussenProces(
    VatDeclarationData vatDeclarationData, String kenmerk) throws IOException, GeneralSecurityException, StatusinformatieServiceFault;

	/**
	 * Geeft alle berichtsoorten waarvoor namens een bepaalde belanghebbende
	 * informatie is aangeleverd.
	 *
	 * @param fiscalNumber@return
	 * @throws GeneralSecurityException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws StatusinformatieServiceFault 
	 */
	GetBerichtsoortenResponse getBerichtsoorten(String fiscalNumber) throws IOException, GeneralSecurityException, StatusinformatieServiceFault;
}
