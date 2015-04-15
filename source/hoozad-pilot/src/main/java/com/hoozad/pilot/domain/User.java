package com.hoozad.pilot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A user.
 */
@Document(collection = "T_USER")
public class User extends AbstractAuditingEntity implements Serializable {

    @Id
    private String id;

    //TODO AFN: Remove? https://github.com/alexfdz/hoozad/issues/39
    @NotNull
    @Size(min = 0, max = 50)
    private String login;

    @Size(min = 0, max = 50)
    @Field("first_name")
    private String firstName;

    @Size(min = 0, max = 50)
    @Field("last_name")
    private String lastName;

    @Email
    @Size(min = 0, max = 100)
    private String email;

    //TODO AFN: Remove
    private boolean activated = false;

    @Size(min = 2, max = 5)
    @Field("lang_key")
    private String langKey;

    //TODO AFN: Remove
    @Size(min = 0, max = 20)
    @Field("activation_key")
    private String activationKey;

    @JsonIgnore
    private Set<Authority> authorities = new HashSet<>();
    private Set<PersistentToken> persistentTokens = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    private Set<ExternalAccount> externalAccounts = new HashSet<>();


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }


    public Set<ExternalAccount> getExternalAccounts() {
        return externalAccounts;
    }

    public void setExternalAccounts(Set<ExternalAccount> externalAccountIds) {
        this.externalAccounts = externalAccountIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (!login.equals(user.login)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", activated='" + activated + '\'' +
                ", langKey='" + langKey + '\'' +
                ", activationKey='" + activationKey + '\'' +
                ", externalAccounts=" + externalAccounts +
                "}";
    }
}
