

let pageObj = {
  
  init(){
    
  },
}

window.addEventListener("load",function(evt){
  header.renderView('../../template/header.htm')
  menu.renderView('../../template/menu.htm')
  novels.renderView('../../template/novels.htm')
  
  pageObj.init(); 
})



