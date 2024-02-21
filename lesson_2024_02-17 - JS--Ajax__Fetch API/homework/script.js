
async function test() {
    let result = await fetch('https://api.openweathermap.org/data/2.5/weather?q=Saint%20Petersburg&unit=metric&appid=6bbc763f2e3a1264a397b8f146680f4a')
    
    let data = await result.json();
    console.log(data);
}

test();

