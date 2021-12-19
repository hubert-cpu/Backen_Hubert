package uc.us_security.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import uc.us_security.entity.Post;
import uc.us_security.entity.Usuario;
import uc.us_security.repository.PostRepository;
import uc.us_security.repository.Usuariorepository;

@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private Usuariorepository usuariorepository;
	@Autowired
	private PostRepository postrepository;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuariorepository.findByUsername(authentication.getName());
		List<Post> accesos = new ArrayList<>();
		accesos = postrepository.findAll();
		Map<String, Object> info = new HashMap<>();		
		info.put("idusuario", usuario.getId());
		info.put("accesos", accesos);
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);		
		return accessToken;
	}

}
