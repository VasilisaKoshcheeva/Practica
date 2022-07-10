function addSchedule(){
   var idTeacher = (document.getElementById("idTeacher").value);
   var idSubject = (document.getElementById("idSubject").value);
   var idCabinet = (document.getElementById("idCabinet").value);
   var idGroup = (document.getElementById("idGroup").value);
   var obj = {};
   var teacher = getTeacher(idTeacher);
   var subject = getSubject(idSubject);
   var cabinet = getCabinet(idCabinet);
   var group = getGroup(idGroup);

    obj.teacher= teacher;
    obj.subject= subject;
    obj.cabinet= cabinet;
    obj.group= group;

    obj.timeExam= document.getElementById("timeExam").value;
    obj.dateExam= document.getElementById("dateExam").value;

    var json = JSON.stringify(obj);
    console.log(json);
    var XHR = new XMLHttpRequest();
    XHR.open("POST","/schedule-management/schedule",true);
    XHR.setRequestHeader('Content-type','application/json; charset=utf-8');
    XHR.send(json);
}