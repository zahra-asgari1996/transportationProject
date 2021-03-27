function w3_open() {
    document.getElementById("main").style.marginLeft = "25%";
    document.getElementById("mySidebar").style.width = "25%";
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("openNav").style.display = 'none';
}

function w3_close() {
    document.getElementById("main").style.marginLeft = "0%";
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("openNav").style.display = "inline-block";
}

function CheckPassword()
{
    var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    if(document.getElementById("pass").value.match(passw))
    {
        return true;
    }else if(document.getElementById("pass").value==""){
        alert('plz fill password !')
        return false;
    }
    else
    {
        alert('Plz inter a valid password !')
        return false;
    }
}



var city = {};
city['teh'] = ['damavand', 'shahriyar'];
city['Az'] = ['tabriz', 'benab'];
city['esf'] = ['esfahan'];
function ChangeCityList() {

    var provinceList = document.getElementById("province");
    var cityList = document.getElementById("city");
    var selCity = provinceList.options[provinceList.selectedIndex].value;
    while (cityList.options.length) {
        cityList.remove(0);
    }
    var cites = city[selCity];
    if (cites) {
        var i;
        for (i = 0; i < cites.length; i++) {
            var c = new Option(cites[i], i);
            cityList.options.add(c);
        }
    }
}
function premium(){
    var weight=document.getElementById("weight").value
    alert('your price is'+weight*20000 + ' and you receive it after one day')
}
function gold(){
    var weight=document.getElementById("weight").value
    alert('your price is'+weight*14000 + ' and you receive it after 3 day')
}
function silver(){
    var weight=document.getElementById("weight").value
    alert('your price is'+weight*10000 + ' and you receive it after 4 day')
}
function show(that){
    if (that.value=="non-doc"){
        document.getElementById("non-doc").style.display = "block";
    }else {
        document.getElementById("non-doc").style.display = "none";
    }

}

var city1 = {};
city1['teh'] = ['damavand', 'shahriyar'];
city1['Az'] = ['tabriz', 'benab'];
city1['esf'] = ['esfahan'];
function origin() {

    var provinceList1 = document.getElementById("Oprovince");
    var cityList1 = document.getElementById("Ocity");
    var selCity1 = provinceList1.options[provinceList1.selectedIndex].value;
    while (cityList1.options.length) {
        cityList1.remove(0);
    }
    var cites1 = city1[selCity1];
    if (cites1) {
        var i;
        for (i = 0; i < cites1.length; i++) {
            var c1 = new Option(cites1[i], i);
            cityList1.options.add(c1);
        }
    }
}

var city2 = {};
city2['teh'] = ['damavand', 'shahriyar'];
city2['Az'] = ['tabriz', 'benab'];
city2['esf'] = ['esfahan'];
function destination() {

    var provinceList2 = document.getElementById("Dprovince");
    var cityList2 = document.getElementById("Dcity");
    var selCity2 = provinceList2.options[provinceList2.selectedIndex].value;
    while (cityList2.options.length) {
        cityList2.remove(0);
    }
    var cites2 = city2[selCity2];
    if (cites2) {
        var i;
        for (i = 0; i < cites2.length; i++) {
            var c2 = new Option(cites2[i], i);
            cityList2.options.add(c2);
        }
    }
}

