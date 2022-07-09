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