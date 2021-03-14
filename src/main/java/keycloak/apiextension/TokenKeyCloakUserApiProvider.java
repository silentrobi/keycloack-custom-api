package keycloak.apiextension;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.UserModel;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.utils.MediaType;

import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collectors;

public class TokenKeyCloakUserApiProvider implements RealmResourceProvider {
    private final KeycloakSession session;
    private final String defaultAttr = "marchent_id";

    public TokenKeyCloakUserApiProvider(KeycloakSession session) {
        this.session = session;
    }

    public void close() {}

    public Object getResource() {
        return this;
    }

    @GET
    @Path("users/search-by-attr")
    @NoCache
    @Produces({MediaType.APPLICATION_JSON})
    @Encoded
    public List<UserModel> searchUsersByAttribute(@DefaultValue(defaultAttr) @QueryParam("attr") String attr,
                                                  @QueryParam("value") String value) {
        return session
                .users()
                .searchForUserByUserAttributeStream(attr, value, session.getContext().getRealm())
                .collect(Collectors.toList());
    }
}