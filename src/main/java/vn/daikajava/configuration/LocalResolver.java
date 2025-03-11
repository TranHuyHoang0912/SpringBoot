package vn.daikajava.configuration;

import ch.qos.logback.core.util.StringUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.List;
import java.util.Locale;

@Configuration
public class LocalResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String languegeHeader = request.getHeader("Accept-Language");
        return StringUtils.hasLength(languegeHeader) ? Locale.lookup(Locale.LanguageRange.parse(languegeHeader),
                List.of(new Locale("en"), new Locale("fr"))) : Locale.getDefault();
    }
}
