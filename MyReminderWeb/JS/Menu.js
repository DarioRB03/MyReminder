const menu = document.querySelector('.menu');
const navegador = document.querySelector('.menu-navegador');
const lista = document.querySelector('.list');
const secciones = document.querySelector('.list__button--click');
const flecha = document.querySelector('.list__arrow');

console.log(navegador)
console.log(menu)
console.log(lista)
console.log(secciones)
console.log(flecha)


menu.addEventListener('click', ()=>{
	navegador.classList.toggle("spread")
    lista.classList.toggle("spread")
    secciones.classList.toggle("spread")
    flecha.classList.toggle("spread")
})

window.addEventListener('click', e=>{
	if(navegador.classList.contains("spread") && e.target	!= navegador && e.target != menu && e.target != lista && e.target != secciones && e.target != flecha	){
		navegador.classList.toggle("spread")
        lista.classList.toggle("spread")
        secciones.classList.toggle("spread")
        flecha.classList.toggle("spread")
	}
})

let listElements = document.querySelectorAll('.list__button--click');

listElements.forEach(listElement => {
    listElement.addEventListener('click', ()=>{
        
        listElement.classList.toggle('arrow');

        let height = 0;
        let menu = listElement.nextElementSibling;
        if(menu.clientHeight == "0"){
            height=menu.scrollHeight;
        }

        menu.style.height = `${height}px`;

        

    })
});