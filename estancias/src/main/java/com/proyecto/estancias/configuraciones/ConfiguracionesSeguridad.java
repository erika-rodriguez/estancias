
package com.proyecto.estancias.configuraciones;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(1)
public class ConfiguracionesSeguridad extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //para que nos pida la contraseña       
                .authorizeRequests()
                // .antMatchers autoriza que todos los que quieran acceder al controlador de administrador tengan el rol de Admin    
                .antMatchers("/ADMIN/*").hasRole("ADMIN")
                
                //autoriza a todos a que puedan ver en lo que esta en css,js,img       
                .antMatchers("/css/*", "/js/*", "/img/*", "/**").permitAll()
                .and().formLogin()
                
                //trabajo el usuario logueado:
                .loginPage("/login") // Que formulario esta mi login
                .loginProcessingUrl("/logincheck")  //como voy a llamar el proceso cuando tuve exito
                .usernameParameter("username") // Como viajan los datos del logueo
                .passwordParameter("password")// Como viajan los datos del logueo
                .defaultSuccessUrl("/inicio") // A que URL viaja cuando tiene exito
                .permitAll()
                .and().logout() // Aca configuro la salida
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll().and().csrf().disable();
        //.CSRF CREA UN TOCKEN DE SEGURIDAD EXTRA
    }
}
