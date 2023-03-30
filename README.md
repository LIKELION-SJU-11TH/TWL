# TWL (Today We Learned)
## Repo 초기 세팅
1. CODE 버튼을 눌러 HTTPS 링크를 복사합니다.
<img width="403" alt="스크린샷 2023-03-30 오후 11 07 06" src="https://user-images.githubusercontent.com/96824025/228886685-1d5632ac-b53b-43f4-b6c3-2b436f56b560.png">

2. terminal을 이용해서 디렉토리를 생성하고 싶은 위치로 이동합니다.
<img width="563" alt="스크린샷 2023-03-30 오후 11 16 27" src="https://user-images.githubusercontent.com/96824025/228886782-1c4b4953-f2c9-45ab-a8b2-2be8ef104f45.png">

3. 위의 링크를 이용해 repository를 clone합니다.
`git clone https://github.com/LIKELION-SJU-11TH/TWL.git`

4. TWL이 생성된 것을 확인할 수 있고 main branch 또한 자동으로 만들어 졌습니다.
<img width="904" alt="스크린샷 2023-03-30 오후 11 17 54" src="https://user-images.githubusercontent.com/96824025/228886914-9cbddb3d-1ae0-4c8d-8a46-6420e1d60520.png">

<img width="505" alt="스크린샷 2023-03-30 오후 11 18 53" src="https://user-images.githubusercontent.com/96824025/228886966-39fb18d6-c878-41df-ae01-d29e6f754d73.png">

5. TWL 폴더에 본인 이름의 디렉토리를 만들어줍니다.
<img width="922" alt="스크린샷 2023-03-30 오후 11 31 45" src="https://user-images.githubusercontent.com/96824025/228887036-a1bd6a1a-8ee8-440c-914e-e1b77cc0916a.png">

6. 해당 변경사항이 적용되도록 add 명령과 commit 명령을 입력해줍니다.

**주의**
**1. add 명령 사용 시 ‘git add .’ 으로 변경사항을 모두 적용하여도 되지만 변경 사항별로 커밋 메시지를 남기기 위해 파일마다 add하는 것을 추천합니다.**

**2. 빈 디렉토리일 경우 추가 설정 없이 add가 되지 않습니다. 디렉토리를 추가하고 첫 파일을 만든 후 add하세요.**

`git add '파일 또는 디렉토리경로'`
<img width="404" alt="스크린샷 2023-03-31 오전 12 07 17" src="https://user-images.githubusercontent.com/96824025/228887142-60c78eeb-29cd-4c8a-8a39-e019168ebb9a.png">
`git commit -m “커밋 메시지”`
<img width="580" alt="스크린샷 2023-03-31 오전 12 10 59" src="https://user-images.githubusercontent.com/96824025/228887191-094dd383-a722-441a-9d20-5f7de8e8d846.png">

7. push 명령을 수행하여 github에 변경사항을 적용합니다.
`git push origin main`
<img width="587" alt="스크린샷 2023-03-31 오전 12 12 33" src="https://user-images.githubusercontent.com/96824025/228887235-664476cc-10f2-4094-819b-0686d5415a4c.png">

<img width="925" alt="스크린샷 2023-03-31 오전 12 13 07" src="https://user-images.githubusercontent.com/96824025/228887295-c0eb356f-8359-445a-b7d7-97d147c51cfc.png">
깃허브에 파일이 올라간 것을 확인할 수 있습니다.

**추가 주의사항**
**!본인의 변경사항을 Push 하기 전에 반드시 pull먼저 할 것!**

아래 폴더는 변경사항이 아직 적용이 안되어있는 상태입니다.
<img width="718" alt="스크린샷 2023-03-31 오전 12 18 29" src="https://user-images.githubusercontent.com/96824025/228887345-cd58fab7-4e2a-41df-91e3-473b106314e9.png">

`git pull`명령어를 통해 github의 최신 정보를 내려받아줍니다.
<img width="697" alt="스크린샷 2023-03-31 오전 12 19 31" src="https://user-images.githubusercontent.com/96824025/228887394-c6884d14-7c64-40f7-88cf-e2b5bd39db27.png">

아래와 같이 github와 동일한 최신 상태를 적용한 이후 본인의 변경사항을 반영해줍시다.
<img width="690" alt="스크린샷 2023-03-31 오전 12 21 00" src="https://user-images.githubusercontent.com/96824025/228887438-8e5fcc27-856e-4877-abd7-541dbd1337a4.png">


## 마크다운 파일 작성법
dongchannN 디렉토리의 Markdown.md 파일을 확인해주세요.
