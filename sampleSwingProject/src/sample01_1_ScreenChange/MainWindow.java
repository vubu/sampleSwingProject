package sample01_1_ScreenChange;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	//フィールド
	ScreenMode screenMode = ScreenMode.TITLE;
	ScreenMode screenMode2 = ScreenMode.GAME;
	//定数
	final int WIDTH = 800;	//フレームの幅
	final int HEIGHT = 600; //フレームの高さ
	//レイアウト（紙芝居のような設定用)
	CardLayout layout = new CardLayout();

	//コンポーネント
	TitlePanel titlePanel;
	GamePanel gamePanel;

	//コンストラクタ
	MainWindow(){
		//ウインドウ左上のアイコンとタイトル
		this.setTitle("タイトルを設定");

		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/elen.png"));
		this.setIconImage(icon.getImage());

		//いつもの
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		//閉じる機能
		this.setResizable(false);							//画面サイズの変更禁止
		this.getContentPane().setBackground(Color.white);   //背景の色
		//this.getContentPane().setBackground(new color(F5F5F5) //白って２００色あんねん
		this.setLayout(layout);								//紙芝居のように設定
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT)); //サイズ設定
		this.pack();										//自動サイズ調整これがないと変なサイズになる
		this.setLocationRelativeTo(null);					//起動時のスクリーンの位置を中央に、(packより後でよぶ)
		//this.setLocation(450,50);							//アンミカ

	}

	//コンストラクタが呼ばれた後メインメソッドから最初に手動で呼び出す
	public void preparePanels() {
		//パネルの準備
		titlePanel = new TitlePanel();
		this.add(titlePanel,"タイトル画面");
		gamePanel = new GamePanel();
		this.add(gamePanel,"ゲーム画面");
		this.pack();
	}

	//preparePanels()が呼ばれた後、メインメソッドからさらに手動で呼び出す
	public void prepareComponents() {
		titlePanel.prepareComponents();
		gamePanel.prepareComponents();
	}

	//スクリーンモードを切り替える
	//メインメソッドから手動で呼び出す
	public void setFrontScreenAndFocus(ScreenMode s) {
		screenMode = s;
		//表示される画面の設定
		switch(screenMode) {
		case TITLE:
			layout.show(this.getContentPane(),"タイトル画面！");
			titlePanel.requestFocus();
			break;
		case GAME:
			layout.show(this.getContentPane(),"ゲーム画面！");
			gamePanel.requestFocus();
			break;
		}
	}
}
