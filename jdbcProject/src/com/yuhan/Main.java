package com.yuhan;

import java.sql.SQLException;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		boolean run2 = true;
		int usersel = 0;
		ItemDao itemdao = new ItemDao();
		UserDao userdao = new UserDao();
		OrdersDao ordersdao = new OrdersDao();
		Item item = new Item();
		User user = new User();
		Orders order = new Orders();
		String item_code = "";
		String user_name = "";
		
		while(run)
		{
			run2 = true;
			System.out.println("---------------------------------------------------------------------------");			 
			System.out.println("1. 상품정보 | 2. 사용자정보 | 3. 주문정보 | 4. 주문완료처리 | 5. 주문조회(일자)");
			System.out.println("---------------------------------------------------------------------------");
			System.out.print("선택>");
			usersel = Integer.parseInt(sc.nextLine());
			switch(usersel)
			{
				case 1:
					while(run2)
					{
					System.out.println("---------------------------------------------------");
					System.out.println("1. 상품정보 등록 | 2. 상품정보 조회 | 9. 상위메뉴");
					System.out.println("---------------------------------------------------");
					System.out.print("선택>>");
					usersel = Integer.parseInt(sc.nextLine());
						switch(usersel)
						{
							case 1:
								System.out.print("상품번호 > ");
								item_code = sc.nextLine();
								
								if(itemdao.findItem(item_code).size() > 0)
								{
									System.out.println("해당 상품번호가 존재합니다.");
									break;
								}
								else
								{
									item.setItem_code(item_code);
									System.out.print("상품명 > ");
									item.setItem_name(sc.nextLine());
									System.out.print("단가 > ");
									item.setPrice(Integer.parseInt(sc.nextLine()));
									System.out.print("스펙 > ");
									item.setSpec(sc.nextLine());
									if(!itemdao.itemInsert(item))
									{
										System.out.println("상품 등록 실패");
										break;
									}
									else
									{
										break;
									}
								}
							case 2:
								System.out.print("상품번호 > ");
								item_code = sc.nextLine();
								ArrayList<Item> items = itemdao.findItem(item_code);
								if(items.size() < 1)
								{
									System.out.println("조회된 상품이 없습니다.");
									break;
								}
								else 
								{
									System.out.println("\t상품번호\t||\t상품명\t||\t단가\t||\t스펙\t");
									for(int i = 0 ; i < items.size() ; i ++)
									{
										System.out.printf("\t%s\t||\t%s\t||\t%d\t||\t%s\t\n"
												, items.get(i).getItem_code()
												, items.get(i).getItem_name()
												, items.get(i).getPrice()
												, items.get(i).getSpec());
									}
									break;
								}
							case 9 : run2 = false; break;
							default : break;
								
						}
					}
					break;
				case 2:
					while(run2)
					{
					System.out.println("---------------------------------------------------");
					System.out.println("1. 사용자정보 등록 | 2. 사용자정보 조회 | 9. 상위메뉴");
					System.out.println("---------------------------------------------------");
					System.out.print("선택>>");
					usersel = Integer.parseInt(sc.nextLine());
					String regEx = "^\\d{3}-\\d{4}-\\d{4}$"; 
						switch(usersel)
						{
							case 1:
								user.setUser_id("U"+userdao.getUserSeq());
								System.out.print("사용자이름 > ");
								user.setUser_name(sc.nextLine());
								System.out.print("전화번호 > ");
								String phone = sc.nextLine();
								if(!Pattern.matches(regEx, phone)) 
								{
								    System.out.println("올바른 휴대전화 형식이 아닙니다. ");
								    break;
								}
								else
								{            
									phone = phone.replace("-", "");
									user.setPhone(phone);
								}

								System.out.print("주소 > ");
								user.setAddress(sc.nextLine());
								if(!userdao.userInsert(user))
								{
									System.out.println("사용자 등록 실패");
									break;
								}
								else
								{
									System.out.println("사용자 등록 완료");
									break;
								}
							case 2:
								System.out.print("사용자이름 > ");
								user_name = sc.nextLine();
								ArrayList<User> users = userdao.findUser(user_name);
								if(users.size() < 1)
								{
									System.out.println("조회된 사용자가 없습니다.");
									break;
								}
								else 
								{
									System.out.println("\t사용자번호\t||\t사용자이름\t||\t전화번호\t\t||\t주소\t");
									for(int i = 0 ; i < users.size() ; i ++)
									{
										System.out.printf("\t%s\t\t||\t%s\t\t||\t%s\t||\t%s\t\n"
												, users.get(i).getUser_id()
												, users.get(i).getUser_name()
												, users.get(i).getPhone()
												, users.get(i).getAddress());
									}
									break;
								}
							case 9 : run2 = false; break;
							default : break;
								
						}
					}
					break;
				case 3: 					
					while(run2)
					{
					System.out.println("---------------------------------------------------");
					System.out.println("1. 주문정보 등록 | 2. 주문정보 조회 | 9. 상위메뉴");
					System.out.println("---------------------------------------------------");
					System.out.print("선택>>");
					usersel = Integer.parseInt(sc.nextLine());
						switch(usersel)
						{
							case 1:
								String ordno = ordersdao.getOrderSeq();
								ArrayList<Orders> list = new ArrayList<Orders>();
								System.out.print("사용자번호 > ");
								String userid = sc.nextLine();
								if(!userdao.checkUser(userid)) {
									System.out.println("해당 사용자는 존재하지 않습니다.");
									continue;
								}

								while(true) 
								{
									order = new Orders();
									System.out.print("상품 > ");
									String itemcd = sc.nextLine();
									if(itemcd == null || itemcd == "")
									{
										break;
									}
									else if (!itemdao.checkItem(itemcd))
									{
										System.out.println("해당상품은 존재하지 않습니다.");
										continue;
									}
									System.out.print("수량 > ");
									int itemqty = sc.nextInt();
									sc.nextLine();
									
									order.setItem_code(itemcd);
									order.setItem_qty(itemqty);
									order.setOrder_no(ordno);
									order.setUser_id(userid);
									list.add(order);
								}
								try 
								{
									ordersdao.createOrderdetailSeq();
									ordersdao.conn.setAutoCommit(false);
									ordersdao.insertOrderdetail(list);
									ordersdao.insertOrders(ordno, userid);
									ordersdao.dropOrderdetailSeq();
									ordersdao.conn.commit();
									System.out.println("주문번호 : " + ordno + " 등록 완료");
								} 
								catch (SQLException e) 
								{
									e.printStackTrace();
								}
								break;
							case 2:
								System.out.print("주문번호 > ");
								String ord_no = sc.nextLine();
								ArrayList<Orders> orders = ordersdao.findOrder(ord_no,"");
								if(orders.size() < 1)
								{
									System.out.println("조회된 사용자가 없습니다.");
									break;
								}
								else 
								{
									System.out.println("\t사용자명\t\t||\t상품명\t\t||\t주문수량\t\t||\t전화번호\t\t||\t주소\t");
									for(int i = 0 ; i < orders.size() ; i ++)
									{
										System.out.printf("\t%s\t\t||\t%s\t\t||\t%d\t\t||\t%s\t||\t%s\t\n"
												, orders.get(i).getUser_name()
												, orders.get(i).getItem_name()
												, orders.get(i).getItem_qty()
												, orders.get(i).getPhone()
												, orders.get(i).getAddress());
									}
									break;
								}
							case 9 : run2 = false; break;
							default : break;
						}
					}
					break;
				case 4:
					while(true)
					{
						System.out.print("주문번호>");
						String ordno = sc.nextLine();
						if(ordno == null || ordno == "")
						{
							System.out.println("주문번호를 입력해주세요.");
							break;
						}
						if(!ordersdao.checkOrders(ordno))
						{
							System.out.println("해당 주문은 없는주문입니다.");
							break;
						}
						
						System.out.print(ordno + " 완료처리 하시겠습니까? Y/N >>");
						String userYN = sc.nextLine();
						if (userYN.equals("Y") || userYN.equals("y"))
						{	
							if(ordersdao.updateOrders(ordno))
							{
								System.out.println(ordno + " 완료처리");
								break;
							}
						}
						else
						{
							break;
						}
					}
					break;
				case 5:
					SimpleDateFormat  dateFormat = new  SimpleDateFormat("yyMMdd");
					while(true)
					{
						System.out.print("주문일자(YYMMDD) > ");
						String orderdate = sc.nextLine();         
//						dateFormat.setLenient(false);
//				        try 
//				        {
//							dateFormat.parse(orderdate);
//						} 
//				        catch (ParseException e)
//				        {
//							System.out.println("날짜형식 오류");
//							break;
//						}
//						if (orderdate == null || orderdate.length() != 6) {
//					            System.out.println("날짜형식 오류");
//					            break;
//					        }
						ArrayList<Orders> orders = ordersdao.findOrder("",orderdate);
						if(orders.size() < 1)
						{
							System.out.println("조회된 주문이 없습니다.");
							break;
						}
						else 
						{
							System.out.println("\t사용자명\t\t||\t상품명\t\t||\t주문수량\t\t||\t전화번호\t\t||\t주소\t");
							for(int i = 0 ; i < orders.size() ; i ++)
							{
								System.out.printf("\t%s\t\t||\t%s\t\t||\t%d\t\t||\t%s\t||\t%s\t\n"
										, orders.get(i).getUser_name()
										, orders.get(i).getItem_name()
										, orders.get(i).getItem_qty()
										, orders.get(i).getPhone()
										, orders.get(i).getAddress());
							}
							break;
						}
					}
					break;
				default : System.out.println("종료"); run = false; break;
			}
		}
		
	}
}
