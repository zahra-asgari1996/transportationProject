function Check() {
    var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    if (document.getElementById("pass").value.match(passw)) {
        return true;
    }
}

var city = {};
city['teh'] = ['--City--', 'damavand', 'shahriyar', 'tehran'];
city['Az'] = ['--City--', 'tabriz', 'benab', 'shabestar'];
city['esf'] = ['--City--', 'esfahan', 'shahin shahr', 'natanz'];
city['zan'] = ['--City--', 'zanjan', 'abhar', 'hidaj'];
city['Al'] = ['--City--', 'karaj', 'asara', 'nazarabad'];
city['Azg'] = ['--City--', 'urmia', 'salmas', 'mahabad'];
city['maz'] = ['--City--', 'sari', 'amol', 'ramsar'];
city['fa'] = ['--City--', 'shiraz', 'marvdasht', 'lar'];

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