package com.armadillo.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.WhitespaceWildcardsFilter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.List;
import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Repository
public class PersonRepository {

    @Autowired
    private LdapTemplate ldapTemplate;
    
    public void setLdapTemplate(LdapTemplate ldapTemplate) {
	      this.ldapTemplate = ldapTemplate;
	   }
    
    

    /**
     * Retrieves all the persons in the ldap server
     * @return list of person names
     */
    public List<String> getPersonNames() { 
        String cn = "Robert Boyle";
        String sn = "Boyle";
        AndFilter filter = new AndFilter();
        filter.and(new EqualsFilter("objectclass", "person"));
        /*filter.and(new EqualsFilter("sn", sn));
        filter.and(new WhitespaceWildcardsFilter("cn", cn));*/
        return ldapTemplate.search(
           "dc=springframework,dc=org", 
           filter.encode(),
           new AttributesMapper() {
              public Object mapFromAttributes(Attributes attrs)
                 throws NamingException {
                 return attrs.get("cn").get();
              }
           });
     }
    
    /** Retrieves a person information
     * @return person
     */
    
    
    
    

}