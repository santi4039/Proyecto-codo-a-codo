// Call the dataTables jQuery plugin
$(document).ready(function() {  //una vez que se carga la pagina hace esta funcion
 // on ready
});

 async function registrarUsuarios() {

    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    let repetirPassword = document.getElementById('txtRepetirPassword').value;

    if(repetirPassword != datos.password){
        alert('Contraseñas diferentes');
        return;
    }

      const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },

        body: JSON.stringify(datos)  //convierte un objeto string a formato JSON


      });

      alert("La cuenta fue creada con exito");
      window.location.href = 'login.html';
      const usuarios = await request.json();


}
