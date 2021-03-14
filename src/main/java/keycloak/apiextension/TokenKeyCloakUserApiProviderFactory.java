package keycloak.apiextension;

import keycloak.apiextension.TokenKeyCloakUserApiProvider;
import org.keycloak.Config.Scope;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.services.resource.RealmResourceProviderFactory;

public class TokenKeyCloakUserApiProviderFactory implements RealmResourceProviderFactory {
    public static final String ID = "token-userapi-rest";

    public RealmResourceProvider create(KeycloakSession session) {
        return new TokenKeyCloakUserApiProvider(session);
    }

    public void init(Scope config) {
    }

    public void postInit(KeycloakSessionFactory factory) {
    }

    public void close() {
    }

    public String getId() {
        return ID;
    }
}