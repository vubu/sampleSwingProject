package sample01_1_ScreenChange;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	/*↑の行はプログラムの試用が変わったことを知らずに古いセーブデータをロードしてしまってバグが発生すること等を防ぐためにIDで区別をつけて管理しておく機能
	今回はセーブデータを使うつもりはないからほとんど意味ない、書かないと警告がでてうざいくらい*/

	//コンポーネント
	JLabel titleLabel;

	//コンストラクタ
	GamePanel(){
		//パネルサイズと貼り付け位置の設定は不要（CardLayoutが勝手に画面サイズに合わせてくれる）
		this.setLayout(null);	//レイアウトの設定
		this.setBackground(Color.blue);//背景色
		//その他の設定をここに追加していく
	}
	//コンストラクタが呼ばれた後手動で呼び出す
	public void prepareComponents() {
		//以降コンポーネントに関する命令
		titleLabel = new JLabel();			//ラベル生成
		titleLabel.setText("GAME画面");		//ラベルに文字を記入
		titleLabel.setBounds(100,200,100,30); //位置とサイズを指定
		this.add(titleLabel);				//ラベルをこのパネルに貼る
	}
}

