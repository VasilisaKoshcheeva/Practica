function addSchedule() {
    var idTeacher = (document.getElementById("idTeacher").value);
    var idSubject = (document.getElementById("idSubject").value);
    var idCabinet = (document.getElementById("idCabinet").value);
    var idGroup = (document.getElementById("idGroup").value);
    var obj = {};
    obj.teacher = idTeacher;
    obj.subject = idSubject;
    obj.cabinet = idCabinet;
    obj.group = idGroup;
    obj.timeExam = document.getElementById("timeExam").value;
    obj.dateExam = document.getElementById("dateExam").value;

    var json = JSON.stringify(obj);
    console.log(json);
    var XHR = new XMLHttpRequest();
    XHR.open("POST", "/schedule-management/schedule", false);
    XHR.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    XHR.send(json);
}

function updateSchedule() {
    var obj = {};
    obj.id = document.getElementById("idSchedule").value;
    var idTeacher = (document.getElementById("idTeacher").value);
    var idSubject = (document.getElementById("idSubject").value);
    var idCabinet = (document.getElementById("idCabinet").value);
    var idGroup = (document.getElementById("idGroup").value);
    obj.teacher = idTeacher;
    obj.subject = idSubject;
    obj.cabinet = idCabinet;
    obj.group = idGroup;
    obj.timeExam = document.getElementById("timeExam").value;
    obj.dateExam = document.getElementById("dateExam").value;

    var json = JSON.stringify(obj);
    console.log(json);
    var XHR = new XMLHttpRequest();
    XHR.open("PUT", "/schedule-management/schedule", false);
    XHR.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    XHR.send(json);
}

function deleteSchedule() {
    var id = document.getElementById("idSchedule").value;
    var XHR = new XMLHttpRequest();
    XHR.open("DELETE", "/schedule-management/schedule/" + id, true);
    XHR.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    XHR.send();
}