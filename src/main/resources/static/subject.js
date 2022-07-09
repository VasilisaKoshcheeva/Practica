function getSubject(id){


    var XHR = new XMLHttpRequest();
    XHR.open("GET","/subject-management/subject/"+id,true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send();


    if(XHR.status === 200){
        return XHR.responseText;
    }
    else{
        alert("Ошибка " + XHR.status);
    }
}