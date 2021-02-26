function getDate()
{
    var date = new Date();
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var seconds = date.getSeconds();

    var days=new Array("Воскресенье","Понедельник","Вторник",
    "Среда","Четверг","Пятница","Суббота");

    var months=new Array("января","февраля","марта","апреля","мая","июня",
    "июля","августа","сентября","октября","ноября","декабря");

//    document.write(days[date.getDay()]+" " +date.getDate()+ " " + months[date.getMonth()]
//    + " " + date.getFullYear() + " г.");

    if(seconds < 10)
    {
        seconds = '0' + seconds;
    }
    document.getElementById('timedisplay').innerHTML = date.getDate()  + ' ' + months[date.getMonth()] + ' ' + date.getFullYear() + ' г.  ' + days[date.getDay()] + ' ' + hours + ':' + minutes + ':' + seconds;
}
setInterval(getDate, 0);