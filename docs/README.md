# 다리건너기 미션
- 위 or 아래 둘 중하나의 칸만 건널 수 있는 다리를 끝까지 건너는 게임
- 다리는 왼쪽에서 오른쪽으로 이어져 있음. 
- 위 아래 둘 중 하나의 칸만 건널 수 있음.

# 기능 요구사항 정리
1. 다리의 길이 입력 
2. 다리는 0과 1 무작위 값을 이용해서 건널 수 있는 칸을 정한다.
   1. 값이 0 인경우 아래, 1인 경우 위 칸이 건널 수 있는 칸이 된다.
3. 위 칸을 건널 수 있는 경우 U, 아래칸을 건널 수 있는 경우 D값으로 나타냄
4. 다리가 생성되면 이동할 칸 선택
   1. 이동할 때 위 칸을 이동하고자 하면 U, 아래 칸은 D를 입력
   2. 다리를 끝까지 건너면 게임 종료
   3. 건너다가 실패하면 게임을 재시작/종료할 수 있음
   - 재시작하면 다리를 새로 생성하지 않고 초기에 만들어 둔 기존의 다리를 사용
   - 종료하면 게임 결과의 총 시도한 횟수는 첫 시도를 포함한 값을 출력
5. 잘못된 값을 입력할 경우 throw IAE & "[ERROR]" 로 시작하는 에러메시지 출력 & 재입력


# 프로그래밍 요구 사항
1. 함수는 10 라인 이내
2. 메소드의 파라미터 개수 최대 3개
3. InputView, OutputView, BridgeGame, BridgeMaker, BridgeRandomNumberGenerator 클래스 사용

- InputView
  - 패키지 변경 가능
  - 이곳에서만 Console.readLine()를 사용할 것
  - 메소드의 시그니처(인자,이름)와 반환 타입 변경 가능
  - 사용자 값 입력을 위해 필요한 메소드 추가 가능

- OutputView
  - 패키지 변경 가능
  - 메소드명 변경 불가능, 인자와 리턴타입은 추가하거나 변경 가능
  - 값 출력을 위해 필요한 메소드 추가 가능 


- BridgeGame
  - 필드 추가 가능
  - 패키지 변경 가능
  - 메소드 이름 변경 불가, 인자와 리턴타입 변경 및 추가 가능
  - 게임 진행을 위해 필요한 메소드 추가 가능

- BridgeMaker
  - BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경 X
  - BridgeMaker의 필드 변경 X

- BridgeRandomNumberGenerator 
  - Random 값 추출은 제공된 bridge.BridgeRandomNumberGenerator의 generate() 활용
  - BridgeRandomNumberGenerator, BridgeNumberGenerator 클래스의 코드는 변경 불가
