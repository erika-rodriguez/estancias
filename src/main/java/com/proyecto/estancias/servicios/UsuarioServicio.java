/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.estancias.servicios;


import com.proyecto.estancias.errores.ErrorServicio;
import com.proyecto.estancias.repositorios.UsuarioRepositorio;
import com.proyecto.estancias.enums.Rol;
import java.util.ArrayList;
import com.proyecto.estancias.entidades.Usuario;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioServicio implements UserDetailsService{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    
    /*
public void registrar(MultipartFile archivo, String alias, String mail, String clave, Date fechaAlta, Date fechaBaja) throws ErrorServicio {

        validar(alias, mail, clave, fechaAlta, fechaBaja);

    }

    public void validar(String alias, String mail, String clave, Date fechaAlta, Date fechaBaja) throws ErrorServicio {

        if (alias == null || alias.isEmpty()) {
            throw new ErrorServicio("El alias no puede ser nulo");
        }

        if (mail == null || mail.isEmpty()) {
            throw new ErrorServicio("El mail no puede ser nulo");
        }
                
        if (clave == null || clave.isEmpty()) {
            throw new ErrorServicio("El clave no puede ser nulo");
        }
    }
    
    */
    
    @Transactional
    public void registrar(MultipartFile archivo, String alias, String email, String clave, Date fechaAlta, Date fechaBaja) throws ErrorServicio {

      

        validar(alias,email, clave,fechaAlta,fechaBaja);

        Usuario usuario;
        usuario = new Usuario();
       
        usuario.setAlias(alias);
        usuario.setEmail(email);
        usuario.setClave(clave);
        usuario.setFechaAlta(fechaAlta);
        usuario.setFechaBaja(fechaBaja);
        //seteo que todos sean usuarios
        usuario.setRol(Rol.USUARIO);
        
        String encriptada = new BCryptPasswordEncoder().encode(clave);
        usuario.setClave(encriptada);
        
 
        usuarioRepositorio.save(usuario);

    }

    @Transactional
    public void modificar(MultipartFile archivo, String id, String alias, String email, String clave, Date fechaAlta, Date fechaBaja) throws ErrorServicio {


        
        validar(alias,email,clave, fechaAlta,fechaBaja);

        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {

            Usuario usuario = respuesta.get();
          usuario.setAlias(alias);
        usuario.setEmail(email);
        usuario.setClave(clave);
        usuario.setFechaAlta(fechaAlta);
        usuario.setFechaBaja(fechaBaja);
        //seteo que todos sean usuarios
        usuario.setRol(Rol.USUARIO);
            String encriptada = new BCryptPasswordEncoder().encode(clave);
            usuario.setClave(encriptada);
/*
            String idFoto = null;
            if (usuario.getFoto() != null) {
                idFoto = usuario.getFoto().getId();
            }

            Foto foto = fotoServicio.actualizar(idFoto, archivo);
            usuario.setFoto(foto);
*/
            usuarioRepositorio.save(usuario);
        } else {

            throw new ErrorServicio("No se encontró el usuario solicitado");
        }

    }

    @Transactional
    public void deshabilitar(String id) throws ErrorServicio {

        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {

            Usuario usuario = respuesta.get();
            //usuario.setBaja(new Date());
            usuarioRepositorio.save(usuario);
        } else {

            throw new ErrorServicio("No se encontró el usuario solicitado");
        }

    }

    @Transactional
    public void habilitar(String id) throws ErrorServicio {

        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {

            Usuario usuario = respuesta.get();
          //  usuario.setBaja(null);
            usuarioRepositorio.save(usuario);
        } else {

            throw new ErrorServicio("No se encontró el usuario solicitado");
        }

    }

    public void validar(String alias, String email, String clave, Date fechaAlta, Date fechaBaja) throws ErrorServicio {

        if (alias == null || alias.isEmpty()) {
            throw new ErrorServicio("El alias del usuario no puede ser nulo");
        }

        if (email == null || email.isEmpty()) {
            throw new ErrorServicio("El email del usuario no puede ser nulo");
        }

      
        if (clave == null || clave.isEmpty() || clave.length() <= 6) {
            throw new ErrorServicio("La clave del usuario no puede ser nula y tiene que tener mas de seis digitos");
        }
           

    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        //traigo un usuario por correo electronico, ya que se loguean por dni o por correo
        Usuario usuario = usuarioRepositorio.buscarPorMail(mail);
        
        if (usuario != null) {
            
            List<GrantedAuthority> permisos = new ArrayList<>();
             
            //segun la persona va a concatenar ese usuario
            GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_"+usuario);
            permisos.add(p1);
         
            //Esto me permite guardar el OBJETO USUARIO LOG, para luego ser utilizado
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession", usuario);

            User user = new User(usuario.getMail(), usuario.getClave(), permisos);
            return user;

        } else {
            return null;
        }

    }

 @Transactional(readOnly=true)
    public Usuario buscarPorId(String id) throws ErrorServicio {

        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {

            Usuario usuario = respuesta.get();
            return usuario;
        } else {

            throw new ErrorServicio("No se encontró el usuario solicitado");
        }

    }
    
   @Transactional(readOnly=true)
    public List<Usuario> todosLosUsuarios(){
 
        return usuarioRepositorio.findAll();
        
    }
    
  
}


