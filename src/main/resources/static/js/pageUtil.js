function makePages(page, size, total){

  console.log(page, size, total)

  // 11, 21, 31 ......
  const startNum = (Math.ceil(page/10) * 10) - 9

  console.log(`StartNum ${startNum}`)

  let result = ""

  //이전 페이지
  if(startNum !== 1){
    result += `<li class="page-item"><a class="page-link" href="${startNum-1}">&laquo;</a></li>`
  }

  let temp = startNum
  while(true){

    if(temp * size > total){
      break;
    }
    console.log(temp)

    result +=`<li class="page-item"><a class="page-link" href="${temp}">${temp}</a></li>`

    temp++;

  } // end while

  if(total % (size * 10) === 1){
    result += `<li class="page-item"><a class="page-link" href="${startNum + 10}">&raquo;</a></li>`
  }

  console.log(result)
  return result
}