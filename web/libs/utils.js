window.$_utils = {
  http(type,url,data,isAlert=true,headers={}){
    return new Promise((resolve,reject)=>{
      let xhr = new XMLHttpRequest();
      xhr.open(type,url,true);
      xhr.setRequestHeader('Content-Type','application/json'); 
      xhr.onreadystatechange = ()=>{
        if(xhr.readyState===4){
          let { response='{}', } = xhr;
          response = JSON.parse(response); 
          console.log('### Response:',response);
          if( xhr.status===200 && response.code==='200'  ) {
            resolve(response.data);
          }
          else{
            isAlert && this.showAlert(response.msg);
            reject(response.msg);
          } 
        }
      }
      
      let reqData = null; 
      if (data) { reqData = JSON.stringify(data) }
      console.log('### Request:',reqData);
      xhr.send(reqData); 
    })
  },
  
  showAlert(msg){
    let _resolve = function(){ }
    let wrap = document.getElementById("alert")
    if (!wrap) {
      wrap = document.createElement("div")
      wrap.id = 'alert';
      wrap.innerHTML = `
        <div class="msg"> ${msg} </div>
        <button type="button" > 确定 </button>
      `
      wrap.querySelector("button").addEventListener("click",(evt)=>{
        wrap.style.display = 'none'; 
        this.showMask(false);
        _resolve(); 
      })
      document.body.appendChild(wrap);
    }
    
    wrap.style.display = 'flex';
    this.showMask(true);
    
    return new Promise((resolve,reject)=>{
      _resolve = resolve;
    })
  },
  showMask(isShow){
    let mask = document.getElementById("mask")
    if (!mask) {
      mask = document.createElement("div")
      mask.id = 'mask'
      document.body.prepend(mask)
    }
    
    mask.style.display = isShow?'block':'none';
  },
}





HTMLElement.prototype.renderView = function(url){
  return new Promise((resolve,reject)=>{
    let xhr = new XMLHttpRequest();
    xhr.open('get',url,true);
    // xhr.setRequestHeader('Content-Type','application/json'); 
    xhr.onreadystatechange = ()=>{
      if(xhr.readyState===4){
        if(xhr.status===200 && xhr.response ) {
          resolve(xhr.response);
        }
        else{
          reject(xhr.response);
        } 
      }
    }
    xhr.send(null); 
  })
  .then(html=>{
    this.innerHTML = html; 
    eval( this.querySelector("script").textContent )
  })
}










