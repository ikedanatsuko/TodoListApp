モチベーションを上げるTodoListApp
====

## 概要
#### トップ画面
- Todoリストを追加できます
- Todoリストのタイトルをクリックすることで詳細を見ることができます  
<img src="https://github.com/utgwn/TodoListApp/blob/master/screenshot/screenshot1.png" width="400">

#### Todoリスト詳細画面
- Todoの追加ができます
- 残りのTodoの数を表示します  
<img src="https://github.com/utgwn/TodoListApp/blob/master/screenshot/screenshot3.png" width="400">

- finishボタンを押すとTodoを完了できます
- Todoを完了する度に褒めてくれます  
<img src="https://github.com/utgwn/TodoListApp/blob/master/screenshot/screenshot4.png" width="400">

#### Todo検索画面
<img src="https://github.com/utgwn/TodoListApp/blob/master/screenshot/screenshot5.png" width="400">

#### 褒め言葉詳細画面
- 好きな褒め言葉を追加できます
- Todoを完了すると、登録されたワードからランダムに１つ選んで褒めてくれます  
<img src="https://github.com/utgwn/TodoListApp/blob/master/screenshot/screenshot7.png" width="400">

## 使っているもの
- Java
- Spring Framework
- Spring JDBC
- PostgreSQL
- Maven

## 設計
MVCモデルのつもりです  
- データベースのそれぞれのテーブルに対応したDao、Entity、Serviceのクラスを作成
- 表示画面ごとにControllerクラスを作成
  - トップ画面に画面遷移する処理はHomeController、Todo詳細画面に画面遷移する処理はTodoController、みたいにした
### データベース
- Todoリストテーブル
- Todoテーブル
- 褒め言葉テーブル
