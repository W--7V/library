



let pageObj = {
  
  render(){
    // 小说列表  
    // let fragment = document.createDocumentFragment()
    // this.novelList.forEach(itm=>{
    //   let wrap = document.createElement("div")
    //   let div = document.createElement("div")
    //   wrap.appendChild(div);
    //   wrap.setAttribute("class","itemWp")
    //   div.setAttribute("class","item")
    //   div.style.backgroundImage = `url(${itm.img})`
    //   fragment.appendChild(wrap)
    // })
    // novels.querySelector(".wrap").appendChild(fragment)
    
  },
  init(){
    this.render(); 
    
  },
}

window.addEventListener("load",function(evt){
  header.renderView('../../template/header_back.htm')
  
  pageObj.init(); 
})

































