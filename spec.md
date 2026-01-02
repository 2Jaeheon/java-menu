# 요구사항 정리

## 시나리오

1. 메뉴 추천 받을 코치를 입력
    - `inputView` 로 입력받음
    - `Parser`가 문자열을 파싱해서 `List<String>` 반환
    - `Controller`는 `List<Coach>`를 생성해서 `Coaches`를 반환
    - [예외]: 코치는 최소 2명, 최대 5명
    - [예외]: 코치의 이름 검증(2 ~ 4글자)

2. 각 코치가 못 먹는 음식을 입력받음
    - `inputView` 로 입력받아서 `parser`가 파싱
    - `coaches` 에게 못먹는 음식을 설정하라고 요청
    - `coaches` 는 각 코치들에게 못먹는 음식을 설정하라고 요청

3. 메뉴 추천을 진행
    - `Controller` 는 `coaches`들에게 메뉴 추천을 요청 (recommand())
    - `coaches` 는 각 요일에 추천할 카테고리를 정함
        - `CategoryPicker`에게 요청해서 카테고리를 정해옴
        - `coaches`는 카테고리 검증을 진행
        - [주의]: Randoms.pickNumberInRange()의 결과가 1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식을 추천
    - `coaches`는 각 `coach`들에게 각 요일별 먹을 메뉴를 요청
        - [주의] : Randoms.shuffle()을 통해 임의의 순서로 섞은 후, 첫 번째 값을 사용
    - [주의]: 각 코치에게 한 주에 중복되지 않는 메뉴를 추천해야 한다
    - [주의]: 한 주에 같은 카테고리는 최대 2회까지만 고를 수 있다.
    -

4. 메뉴 추천 결과를 출력


# 구현 목록
- [ ] 