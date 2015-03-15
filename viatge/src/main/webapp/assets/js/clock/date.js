var monthNames = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
    "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
];
var dayNames = ["Dom, ", "Seg, ", "Ter, ", "Qua, ", "Qui, ", "Sex, ", "Sab, "]

var newDate = new Date();
$('#Date').html(dayNames[newDate.getDay()] + " " + newDate.getDate() + ' ' + monthNames[newDate.getMonth()] + ' ' + newDate.getFullYear());
