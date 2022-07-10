function addTeacher(){

    var obj = {};
    obj.lastName = document.getElementById("lastName").value;
    obj.firstName = document.getElementById("firstName").value;
    obj.middleName = document.getElementById("middleName").value;
    var json = JSON.stringify(obj);
    console.log(json);
    var XHR = new XMLHttpRequest();
    XHR.open("POST","/teachers-management/teacher",true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send(json);
}

function updateTeacher(){
    var obj = {};
    obj.id = document.getElementById("idTeacher").value;
    obj.lastName = document.getElementById("lastName").value;
    obj.firstName = document.getElementById("firstName").value;
    obj.middleName = document.getElementById("middleName").value;
    var json = JSON.stringify(obj);
    console.log(json);
    var XHR = new XMLHttpRequest();
    XHR.open("PUT","/teachers-management/teacher",true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send(json);
}

function deleteTeacher(){
    var id= document.getElementById("idTeacher").value;
    var XHR = new XMLHttpRequest();
    XHR.open("DELETE","/teachers-management/teacher/"+ id,true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send();
}

function getTeacher(id){

    var XHR = new XMLHttpRequest();
    XHR.open("GET","/teachers-management/teacher/"+id,true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send();
    console.log(XHR.status +"   " +XHR.responseText);
    if(XHR.status === 200){
        return XHR.responseText;
    }
    else{
        alert("Ошибка " + XHR.status);
    }
}