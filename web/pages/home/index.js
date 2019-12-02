
let page = {
  menuList: [
    {
      name: '首页',
    },
    {
      name: '网站介绍',
    },
    {
      name: '最新电子书',
    },
    {
      name: '热门电子书',
    },
    {
      name: '在线留言',
    },
    {
      name: '会员登录',
    },
    {
      name: '管理登录',
    },
  ],
  
  novelList: [
    {
      name: '',
      img: '../../assets/imgs/novel.jpg',
    },
    {
      name: '',
      img: '../../assets/imgs/novel.jpg',
    },
    {
      name: '',
      img: '../../assets/imgs/novel.jpg',
    },
    {
      name: '',
      img: '../../assets/imgs/novel.jpg',
    },
    {
      name: '',
      img: '../../assets/imgs/novel.jpg',
    },
    {
      name: '',
      img: '../../assets/imgs/novel.jpg',
    },
    {
      name: '',
      img: '../../assets/imgs/novel.jpg',
    },
    {
      name: '',
      img: '../../assets/imgs/novel.jpg',
    },
  ],
  
  render(){
    // 菜单 
    let menuHtml = ''
    this.menuList.forEach(itm=>{
      menuHtml += `<div class="item">${itm.name}</div>`
    })
    menu.innerHTML = menuHtml
    
    // 小说列表  
    let fragment = document.createDocumentFragment()
    this.novelList.forEach(itm=>{
      let wrap = document.createElement("div")
      let div = document.createElement("div")
      wrap.appendChild(div);
      wrap.setAttribute("class","itemWp")
      div.setAttribute("class","item")
      div.style.backgroundImage = `url(${itm.img})`
      fragment.appendChild(wrap)
    })
    novels.querySelector(".wrap").appendChild(fragment)
    
  },
  init(){
    this.render(); 
    
  },
}

window.addEventListener("load",function(evt){
  page.init(); 
})

































