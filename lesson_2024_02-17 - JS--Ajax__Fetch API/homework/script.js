
async function searchByCity(city) {
    let result = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=${city}&unit=metric&appid=6bbc763f2e3a1264a397b8f146680f4a`);
    
    let data = await result.json();
    console.log(data);
    return data;
}

let myForm = document.forms.weatherSearch;

myForm.addEventListener('submit', async ()=>{
    event.preventDefault();  // выключаем стандартное поведение submit
    let city = myForm.city.value;

    let data = await searchByCity(city);
    let cityName = data.name;
    let cityTemp = (data.main.temp - 273.15).toFixed(1);
    let cityTempFL = (data.main.feels_like - 273.15).toFixed(1);
    let cityClouds = data.clouds.all;
    let cityHumidity = data.main.humidity;
    let cityWindSpeed = data.wind.speed;
    let cityWindDirection = data.wind.deg;
    let cityPressure = data.main.pressure;
    let weatherIcon = data.weather[0]['icon'];
    console.log(weatherIcon);

    myForm.reset();  // сбрасываем содержимое поля input
    renderParameters(cityName, cityTemp, cityTempFL, cityClouds, cityHumidity, cityWindSpeed, cityWindDirection, cityPressure, weatherIcon);
})

let resultData = document.querySelector('.resultData');

function renderParameters(cityName, cityTemp, cityTempFL, cityClouds, cityHumidity, cityWindSpeed, cityWindDirection, cityPressure, weatherIcon) {
    resultData.innerHTML = '';
    resultData.hidden = false;
    resultData.innerHTML += `
        <div class="cityName">${cityName}</div>
        <div class="cityTemp"><img src="https://openweathermap.org/img/wn/${weatherIcon}.png"> ${cityTemp}&deg;C</div>
        <div class="cityTempFL">Feels like: ${cityTempFL}&deg;C</div>
        <div class="cityClouds">Clouds: ${cityClouds}%</div>
        <div class="cityHumidity">Humidity: ${cityHumidity}%</div>
        <div class="cityWind">Wind: '${windDirection(cityWindDirection)}' ${cityWindSpeed} m/s</div>
        <div class="cityPressure">Pressure: ${cityPressure} hPa</div>
    `;
};

function windDirection(cityWindDirection) {
    let direction;
    if (cityWindDirection >= 337.5 && cityWindDirection < 22.5) {
        direction = 'N';
    } else if (cityWindDirection >= 22.5 && cityWindDirection < 67.5) {
        direction = 'NE';
    } else if (cityWindDirection >= 67.5 && cityWindDirection < 112.5) {
        direction = 'E';
    } else if (cityWindDirection >= 112.5 && cityWindDirection < 157.5) {
        direction = 'SE';
    } else if (cityWindDirection >= 157.5 && cityWindDirection < 202.5) {
        direction = 'S';
    } else if (cityWindDirection >= 202.5 && cityWindDirection < 247.5) {
        direction = 'SW';
    } else if (cityWindDirection >= 247.5 && cityWindDirection < 292.5) {
        direction = 'W';
    } else if (cityWindDirection >= 292.5 && cityWindDirection < 337.5) {
        direction = 'NW';
    }
    return direction;
}
