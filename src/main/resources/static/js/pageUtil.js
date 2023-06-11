
// page : 현재 페이지 번호
// size : 한 페이지에 표시될 항목의 수
// total : 전체 항목의 수
function makePages(page, size, total){

  // log 출력
  console.log(page, size, total)

  // startNum : 이 값은 페이지 번호를 10으로 나눈 뒤 올림한 결과에
  // 10을 곱하고 9를 뺀 값
  // EX : page 가 11 이면 startNum 은 11
  const startNum = (Math.ceil(page/10) * 10) - 9

  console.log(`StartNum ${startNum}`)

  // 함수는 결과를 저장할 result 변수를 빈 문자열로 초기화
  let result = ""

  //이전 페이지
  if(startNum !== 1){
  // startNum 이 1이 아닌 경우 이전 페이지를 나타내는 Html 링크를 result 에 추가
  // 링크의 URL 은 startNum 에서 1을 뺀 값
    result += `<li class="page-item"><a class="page-link" href="${startNum-1}">&laquo;</a></li>`
  }

  //  Temp 변수를 startNum 으로 초기화 후 무한루프
  let temp = startNum
  while(true){
    // temp * size 가 total 보다 큰 경우 루프 종료
    if(temp * size > total){
      break;
    }
    // 로그 출력
    console.log(temp)

    // 현재 페이지 번호를 나타내는 HTML 링크를 result 에 추가
    // 링크의 URL 은 temp 로 지정
    result +=`<li class="page-item"><a class="page-link" href="${temp}">${temp}</a></li>`

    temp++;

  } // end while

  // total 을 size * 10으로 나눈 나머지가 1인 경우,
  // 다음 페이지를 나타내는 HTML 링크를 result 에 추가
  // 링크의 URL 은 startNum 에 10을 더한 값
  if(total % (size * 10) === 1){
    result += `<li class="page-item"><a class="page-link" href="${startNum + 10}">&raquo;</a></li>`
  }

  // 로그 출력
  console.log(result)
  return result
}