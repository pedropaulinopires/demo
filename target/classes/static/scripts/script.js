function previewBeforeUpload(id){
    document.querySelector("#"+id).addEventListener("change",function(e){
      if(e.target.files.length == 0){
        document.querySelector("#"+id+"-preview img").src = "https://bit.ly/3ubuq5o";
        return;
      }
      let file = e.target.files[0];
      let url = URL.createObjectURL(file);
      document.querySelector("#"+id+"-preview img").src = url;
    });
  }

  previewBeforeUpload("file-1");
  previewBeforeUpload("file-2");
  previewBeforeUpload("file-3");
  previewBeforeUpload("file-4");
  previewBeforeUpload("file-5");