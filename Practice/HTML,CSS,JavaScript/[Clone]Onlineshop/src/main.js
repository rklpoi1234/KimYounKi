
//fetch the items from the JSON file
function loadItems() {
    return fetch('data/data.json')
    .then(response => response.json())
    .then(json => json.items);
}

function displayItmes(items) {
    const container = document.querySelector('.items');
    container.innerHTML = items.map(item => createHTMLString(item)).join('');
}

function createHTMLString(item) {
    return `
    <li class="item">
        <img src="${item.image}" alt="${item.type}">
        <span>${item.gender}, ${item.size}</span>
    </li>`;
}

function onButtonClick(event, items) {
    const dataset = event.target.dataset;
    const key = dataset.key;
    const value = dataset.value;

    if (key ==null || value == null){
       return;
    }
    displayItmes(items.filter(item => item[key] === value))
}

function setEventListeners(items) {
    const logo = document.querySelector('.logo');
    const buttons = document.querySelector('.buttons');
    logo.addEventListener('click', ()=>displayItmes(items));
    buttons.addEventListener('click', event=>onButtonClick(event,items));
}


//main
loadItems()
.then(items => {
    console.log(items);
    displayItmes(items);
    setEventListeners(items)
})
.catch(console.log);