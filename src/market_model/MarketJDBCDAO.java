package market_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarketJDBCDAO implements MarketDAO_interface {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/mmdf?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "123456"; 

    private static final String INSERT_MARKET_STMT = 
            "INSERT INTO market (market_description, market_img, market_location, market_start, market_end, market_fee, applicant_population, applicant_limit, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_MARKET_STMT = 
            "SELECT market_id, market_description, market_img, market_location, market_start, market_end, market_fee, applicant_population, applicant_limit, start_date, end_date FROM market ORDER BY market_id";
    private static final String UPDATE_MARKET_STMT = 
            "UPDATE market SET market_description=?, market_img=?, market_location=?, market_start=?, market_end=?, market_fee=?, applicant_population=?, applicant_limit=?, start_date=?, end_date=? WHERE market_id=?";
    private static final String GET_ONE_STMT = 
            "SELECT market_id, market_description, market_img, market_location, market_start, market_end, market_fee, applicant_population, applicant_limit, start_date, end_date FROM market WHERE market_id=?";

    public void insert(MarketVO marketVO) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
        Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(INSERT_MARKET_STMT);
            pstmt.setInt(1,marketVO.getMarket_id());
            pstmt.setString(2, marketVO.getMarket_description());
            pstmt.setBytes(3, marketVO.getMarket_img());
            pstmt.setString(4, marketVO.getMarket_location());
            pstmt.setTimestamp(5, marketVO.getMarket_start());
            pstmt.setTimestamp(6, marketVO.getMarket_end());
            pstmt.setInt(7, marketVO.getMarket_fee());
            pstmt.setInt(8, marketVO.getApplicant_population());
            pstmt.setInt(8, marketVO.getApplicant_limit());
            pstmt.setTimestamp(10, marketVO.getStart_date());
            pstmt.setTimestamp(11, marketVO.getEnd_date());

            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Coudln't load database driver " + e.getMessage());
        } catch(SQLException se) {
        	throw new RuntimeException("A database error occurred." + se.getMessage());
        }
        finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
    
    public void update(MarketVO marketVO) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
        	Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(UPDATE_MARKET_STMT);
            pstmt.setInt(1, marketVO.getMarket_id());
            pstmt.setString(2, marketVO.getMarket_description());
            pstmt.setBytes(3, marketVO.getMarket_img());
            pstmt.setString(4, marketVO.getMarket_location());
            pstmt.setTimestamp(5, marketVO.getMarket_start());
            pstmt.setTimestamp(6, marketVO.getMarket_end());
            pstmt.setInt(7, marketVO.getMarket_fee());
            pstmt.setInt(8, marketVO.getApplicant_population());
            pstmt.setInt(9, marketVO.getApplicant_limit());
            pstmt.setTimestamp(10, marketVO.getStart_date());
            pstmt.setTimestamp(11, marketVO.getEnd_date());

            pstmt.executeUpdate();
        }catch ( ClassNotFoundException e) {
        	throw new RuntimeException("Couldn't load database driver." + e.getMessage());
        }
        catch (SQLException se) {
            throw new RuntimeException("A database error occurred." + se.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if(con != null) {
            	try {
            		con.close();
            	}catch(Exception e) {
            		e.printStackTrace(System.err);
            	}
            }
        }
    }
    
    public void remove(Integer market_id) {
    	
    }
    
    public MarketVO FindByPrimaryKey(Integer market_id) {
        MarketVO marketVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
        	Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ONE_STMT);
            pstmt.setInt(1, market_id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                marketVO = new MarketVO();
                marketVO.setMarket_id(rs.getInt("market_id"));
                marketVO.setMarket_description(rs.getString("market_description"));
                marketVO.setMarket_img(rs.getBytes("market_img"));
                marketVO.setMarket_location(rs.getString("market_location"));
                marketVO.setMarket_start(rs.getTimestamp("market_start"));
                marketVO.setMarket_end(rs.getTimestamp("market_end"));
                marketVO.setMarket_fee(rs.getInt("market_fee"));
                marketVO.setApplicant_population(rs.getInt("applicant_population"));
                marketVO.setApplicant_limit(rs.getInt("applicant_limit"));
                marketVO.setStart_date(rs.getTimestamp("start_date"));
                marketVO.setEnd_date(rs.getTimestamp("end_date"));
            }
        } catch (ClassNotFoundException e) {
        	throw new RuntimeException("Couldn't load database driver" + e.getMessage());
        }
        catch (SQLException se) {
            throw new RuntimeException("A database error occurred. " + se.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        } return marketVO;
    } 

    public List<MarketVO> getAll() {
        List<MarketVO> list = new ArrayList<MarketVO>();
        MarketVO marketVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
        	Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ALL_MARKET_STMT);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                marketVO = new MarketVO();
                marketVO.setMarket_id(rs.getInt("market_id"));
                marketVO.setMarket_description(rs.getString("market_description"));
                marketVO.setMarket_img(rs.getBytes("market_img"));
                marketVO.setMarket_location(rs.getString("market_location"));
                marketVO.setMarket_start(rs.getTimestamp("market_start"));
                marketVO.setMarket_end(rs.getTimestamp("market_end"));
                marketVO.setMarket_fee(rs.getInt("market_fee"));
                marketVO.setApplicant_population(rs.getInt("applicant_population"));
                marketVO.setApplicant_limit(rs.getInt("applicant_limit"));
                marketVO.setStart_date(rs.getTimestamp("start_date"));
                marketVO.setEnd_date(rs.getTimestamp("end_date"));
                list.add(marketVO);
            }
        } catch(ClassNotFoundException e) {
        	throw new RuntimeException("Couldn't load database driver" + e.getMessage());
        
        }
        catch (SQLException se) {
            throw new RuntimeException("A database error occurred." + se.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        return list;
    
    }
}
