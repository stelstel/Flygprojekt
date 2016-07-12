package flyace;

class NoPlanesExistsException extends Exception {

    public NoPlanesExistsException(String the_company_owns_no_planes) {
        System.err.println(the_company_owns_no_planes);
    }
    
}
