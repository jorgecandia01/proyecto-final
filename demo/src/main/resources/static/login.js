//Añado un listener con jquery sobre el botón para obtener
//la sugerencia del campo de input
var id =2;
const initListeners = () =>{
    $("#btnLogin").on("click", () =>{
        let email = $("#txtEmail").val();
        let password = $("#txtPassword").val();
        console.log("Botón pulsado /// "+email+password)

        if((email.trim() !== "") && (password.trim() !== "")){
            id++;
            getUser(id);
            loginUpdate(id);
        }
    });
}

const addUser = async (email, password) => {
    let request = await fetch("/user",{
    method : "POST",
    body : JSON.stringify({id: 1, email: email, password: password}),
    credentials: "same-origin",
    headers: {"Content-Type": "application/json",},
    dataType: "json",});
    //console.log(request)
    }


const getUser = async (id) =>{
    let request = await fetch("/user/"+id);
    if(request.status === 200){
        console.log("Usuario obtenido con éxito");
        let usuario = await request.json();
        console.log(usuario)
    } else {
        console.log("Error al obtener el usuario");
    }
}

function loginUpdate(id){
    window.open("http://localhost:8080/user/"+id,"_self");
    // var btnL = document.getElementById(btnlogin);
    // btnL.textContent = email;
    // btnS.setAttribute('href','javascript:;');
    // var btnS = document.getElementById(btnsignup);
    // btnS.textContent = "LOG OUT";
    // btnS.setAttribute('href','index.html');
}
