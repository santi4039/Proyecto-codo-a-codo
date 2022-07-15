// Call the dataTables jQuery plugin
$(document).ready(function() {  //una vez que se carga la pagina hace esta funcion
    cargarUsuarios();
  $('#usuarios').DataTable();
});

 async function cargarUsuarios() {

      const request = await fetch('api/usuarios', {
        method: 'GET',
        headers: getHeaders()
      });

      const usuarios = await request.json();

      let ListadoHtml = '';

      for(let usuario of usuarios){

      let telefono = usuario.telefono == null ? '-' : usuario.telefono;

      let usuarioHtml = '<tr><td>'+ usuario.id +'</td><td>'+ usuario.nombre +' '+ usuario.apellido +'</td><td>'
       + usuario.email + '</td><td>' + telefono
       + '</td><td><button onclick= "eliminarUsuario('+ usuario.id +')">Eliminar Usuario</button><button href="registrar.html"  onclick="editarUsuario('+ usuario.id +')" style="margin-left:10px;" >Editar Usuario</button></td></tr>';

       ListadoHtml += usuarioHtml;

       }

      document.querySelector("#usuarios tbody").outerHTML = ListadoHtml;

}

function getHeaders(){  //Retorna los headers

    return{
       'Accept': 'application/json',
       'Content-Type': 'application/json',
       'Authorization': localStorage.token
      };
}


async function eliminarUsuario(id){

    if(!confirm('¿Desea eliminar este usuario?'))
    {
        return;
    }

    const request = await fetch('api/usuarios/' + id, {
            method: 'DELETE',
            headers: getHeaders()
          });

     location.reload();
}

async function editarUsuario(id){

     if(!confirm('¿Desea editar este usuario?'))
        {
            return;
        }

         const request = await fetch('api/usuarios/' + id, {
                    method: 'PUT',
                    headers: getHeaders()
                  });



}
