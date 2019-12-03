window.$_utils = {
  http(type,url,data,headers,isSuccess=true){
    if (isSuccess) {
      return Promise.resolve({
        key1: 'aaa',
        key2: 'bbb',
      });
    }
    else {
      return Promise.reject('Error')
    }
    return new Promise((resolve,reject)=>{
      let xhr = new XMLHttpRequest();
      xhr.open(type,url,true);
      xhr.setRequestHeader('Content-Type','application/json'); 
      xhr.onreadystatechange = function(){
        if(xhr.readyState===4){
          if(xhr.status===200 && xhr.response ) {
            resolve(xhr.response);
          }
          else{
            reject(xhr.response);
          } 
        }
      }
      
      let reqData = null; 
      if (data) { reqData = JSON.stringify(data) }
      xhr.send(reqData); 
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
    xhr.onreadystatechange = function(){
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










