
async function test() {
    let result = await fetch('https://omdbapi.com/?s=Rider&apikey=5c3f2d56');
    let data = await result.json();
    console.log(data);

    for (const item of data.Search) {
        console.log(item.Title);
    }
}

test();

