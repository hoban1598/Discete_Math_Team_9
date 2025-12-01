# Git 간단 사용 설명서 (초보자용)

## 🎯 딱 4가지만 알면 됩니다!

---

## 1️⃣ 처음 시작 (한 번만)

### 프로젝트 다운로드
```bash
# 원하는 폴더에서 실행
git clone https://github.com/hoban1598/Discete_Math_Team_9.git
cd Discete_Math_Team_9
```

**끝!** 이제 코딩 시작하면 됩니다.

---

## 2️⃣ 코딩 전 (매번 해야 함)

### 최신 코드 받아오기
```bash
git pull
```

**왜 필요한가요?**  
→ 팀원이 올린 최신 코드를 받아옵니다.

---

## 3️⃣ 코딩 후 (내 작업 올리기)

### 3단계로 올리기
```bash
# 1단계: 변경사항 확인
git status

# 2단계: 내 작업 저장
git add .
git commit -m "무엇을 작업했는지 간단히 설명"

# 3단계: GitHub에 올리기
git push
```

**예시:**
```bash
git add .
git commit -m "Graph.java DFS 구현 완료"
git push
```

---

## 4️⃣ 충돌 났을 때 (가끔 발생)

### 충돌 해결 방법
```bash
# 1. 최신 코드 받기
git pull

# 2. 충돌 메시지가 나오면
#    → 충돌 파일을 열어서 직접 수정
#    → <<<<<<<, =======, >>>>>>> 표시 부분 찾기
#    → 필요한 코드만 남기고 나머지 삭제

# 3. 수정 완료 후
git add .
git commit -m "충돌 해결"
git push
```

---

## 📝 자주 쓰는 명령어 요약

| 명령어 | 언제 쓰나요? |
|--------|-------------|
| `git clone [주소]` | 처음 프로젝트 받을 때 (한 번만) |
| `git pull` | 코딩 시작 전 (최신 코드 받기) |
| `git status` | 내가 뭘 수정했는지 확인 |
| `git add .` | 모든 변경사항 저장 준비 |
| `git commit -m "메시지"` | 변경사항 설명 |
| `git push` | GitHub에 업로드 |

---

## 🔄 일반적인 작업 흐름

```
1. git pull          (최신 코드 받기)
   ↓
2. 코딩 작업
   ↓
3. git add .         (저장 준비)
   ↓
4. git commit -m     (설명 작성)
   ↓
5. git push          (업로드)
```

---

## ⚠️ 주의사항

### ✅ 해야 할 것
- 코딩 시작 전 항상 `git pull`
- 작업 완료 후 바로 `git push`
- commit 메시지는 한글로 간단히

### ❌ 하면 안 되는 것
- `git pull` 없이 코딩 시작 → 충돌 발생!
- 여러 날 작업 후 한 번에 push → 충돌 위험!
- 중요한 작업 전 백업 안 함

---

## 🆘 문제 해결

### Q1: "충돌(conflict)"이 뭔가요?
A: 나와 팀원이 같은 파일을 동시에 수정했을 때 발생합니다.

### Q2: push가 안 돼요!
A: `git pull` 먼저 하세요. 그래도 안 되면 팀원과 상의!

### Q3: 실수로 잘못 올렸어요!
A: 당황하지 말고 팀원에게 알리세요. 되돌릴 수 있습니다.

### Q4: 명령어 실수했어요!
A: `git status`로 현재 상태 확인 → 팀원과 상의

---

## 📞 실전 예시

### Person 1 (Graph.java 작업)
```bash
# 오전 9시
git pull                              # 최신 코드 받기
# Graph.java 코딩...

# 오후 2시
git status                            # 뭘 수정했나 확인
git add .
git commit -m "Graph addEdge 구현"
git push                              # 올리기 완료!
```

### Person 2 (Dijkstra.java 작업)
```bash
# 오후 3시
git pull                              # Person 1 코드 받기
# Dijkstra.java 코딩...

# 오후 6시
git add .
git commit -m "Dijkstra 알고리즘 구현"
git push                              # 올리기 완료!
```

---

## 🎓 핵심 정리

1. **시작 전**: `git pull` (최신 코드)
2. **작업 후**: `git add . → git commit → git push` (내 코드 올리기)
3. **자주 올리기**: 하루 1-2번 push 권장
4. **막히면**: 팀원과 상의!

---

**이것만 알면 충분합니다! 화이팅! 💪**

