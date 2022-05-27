const menu = document.querySelector('.menu');
const navegador = document.querySelector('.menu-navegador');

console.log(navegador)
console.log(menu)

menu.addEventListener('click', ()=>{
	navegador.classList.toggle("spread")
})

window.addEventListener('click', e=>{
	if(navegador.classList.contains("spread") && e.target	!= navegador && e.target != menu	){
		navegador.classList.toggle("spread")
	}
})


function saludo(){
	alert("Bienvenido a Shoes Infinity");}