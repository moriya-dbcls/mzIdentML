package psidev.psi.pi.validator.objectrules.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import uk.ac.ebi.jmzidml.model.mzidml.CvParam;

public class ObjectRuleUtil {
    /**
     * Checks, if one of the accessions occurs in the list of cvParams.
     * 
     * @param cvParams
     * @param accessions
     * @return The list of {@link CvParam} found, or an empty list if not found
     **/
    public static List<CvParam> checkAccessionsInCVParams(List<CvParam> cvParams, Collection<String> accessions) {
        List<CvParam> ret = new ArrayList<>();
        
        if (cvParams != null && accessions != null) {
            for (String accession : accessions) {
                CvParam cvParam = checkAccessionsInCVParams(cvParams, accession);
                if (cvParam != null) {
                    ret.add(cvParam);
                }
            }
        }
        
        return ret;
    }

    /**
     * Checks, if the accession occurs in the list of cvParams.
     * 
     * @param cvParams
     * @param accession
     * @return The CvParam found or null if not found
     */
    public static CvParam checkAccessionsInCVParams(List<CvParam> cvParams, String accession) {
        if (cvParams != null && accession != null) {
            for (CvParam cvParam : cvParams) {
                if (accession.equals(cvParam.getAccession()))
                    return cvParam;
            }
        }
        
        return null;
    }
}