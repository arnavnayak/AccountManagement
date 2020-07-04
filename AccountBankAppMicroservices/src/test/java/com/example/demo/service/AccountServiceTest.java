/*
 * package com.example.demo.service;
 * 
 * import static org.assertj.core.api.Assertions.assertThat; import static
 * org.junit.Assert.*; import static org.mockito.Mockito.verify;
 * 
 * import java.util.ArrayList; import java.util.Optional;
 * 
 * import javax.validation.constraints.AssertTrue;
 * 
 * import org.hibernate.annotations.Where; import org.json.JSONArray; import
 * org.json.JSONException; import org.junit.Before; import org.junit.Test;
 * import org.junit.runner.RunWith; import org.mockito.InjectMocks; import
 * org.mockito.Mock; import org.mockito.Mockito; import
 * org.mockito.MockitoAnnotations; import org.skyscreamer.jsonassert.JSONAssert;
 * import org.skyscreamer.jsonassert.JSONCompareMode; import
 * org.springframework.boot.test.json.JsonContentAssert; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.example.demo.model.AccountOpeningDetails; import
 * com.example.demo.repository.AccountRepository;
 * 
 * @RunWith(SpringRunner.class) public class AccountServiceTest {
 * 
 * 
 * 
 * @Mock AccountRepository accountRepository;
 * 
 * 
 * @Mock AccountOpeningDetails account;
 * 
 * @InjectMocks AccountService accountService;
 * 
 * AccountOpeningDetails accounts;
 * 
 * 
 * //private Optional<Account> accountIdPresent;
 * 
 * @Before public void setUp() throws Exception {
 * MockitoAnnotations.initMocks(this); MockitoAnnotations.initMocks(account);
 * accounts=new AccountOpeningDetails(); }
 * 
 * @Test public void testViewAllAccountSuccess() throws JSONException {
 * ArrayList<AccountOpeningDetails> accountList= new
 * ArrayList<AccountOpeningDetails>();
 * Mockito.when(accountRepository.findAll()).thenReturn(accountList);
 * 
 * ArrayList<AccountOpeningDetails> result = accountService.viewAllAccount();
 * 
 * String actual =
 * "{accountNo:1, accountName:\"John\", accountType:\"Savings Account\",accountBalance:10000}"
 * ; JSONAssert.assertEquals(
 * "{accountNo:1, accountName:\"John\", accountType:\"Savings Account\",accountBalance:10000}"
 * , actual, JSONCompareMode.STRICT); assertEquals(accountList, result);
 * verify(accountRepository).findAll();
 * 
 * }
 * 
 * @Test public void testViewAllAccountFailure() throws JSONException {
 * 
 * Mockito.when(accountRepository.findAll()).thenReturn(null);
 * 
 * ArrayList<AccountOpeningDetails> result = accountService.viewAllAccount();
 * 
 * assertEquals(null, result); verify(accountRepository).findAll();
 * 
 * }
 * 
 * 
 * @Test public void testAddAccountSuccess() {
 * 
 * accounts.setAccountNo(1);
 * Mockito.when(accountRepository.save(accounts)).thenReturn(accounts);
 * accountService.addAccount(accounts); assertEquals(accounts.getAccountNo(),
 * 1); verify(accountRepository).save(accounts); }
 * 
 * @Test public void testAddAccountFailure() {
 * 
 * Mockito.when(accountRepository.save(null)).thenReturn(0);
 * accounts.setAccountNo(0); accountService.addAccount(accounts);
 * assertEquals(accounts.getAccountNo(),0);
 * verify(accountRepository).save(accounts); }
 * 
 * @Test public void testViewAccountByIdSuccess() {
 * 
 * Optional<AccountOpeningDetails> accountIdPresent = Optional.of(account);
 * 
 * long accountId = 1; accounts.setAccountNo(1);
 * 
 * Mockito.when(accountRepository.findById(accountId)).thenReturn(
 * accountIdPresent); assertThat(accountIdPresent).isPresent();
 * 
 * accountService.viewAccountById(accountId);
 * verify(accountRepository).findById(accountId); }
 * 
 * @Test public void testViewAccountByIdFailure() {
 * 
 * long accountId = 1; accounts.setAccountNo(1);
 * accountService.viewAccountById(accountId);
 * verify(accountRepository).findById(accountId); }
 * 
 * 
 * @Test public void testUpdateAccountSuccess() {
 * Mockito.when(accountRepository.save(account)).thenReturn(accounts);
 * AccountOpeningDetails result=accountService.updateAccount(account);
 * assertEquals(accounts, result); verify(accountRepository).save(account); }
 * 
 * @Test public void testUpdateAccountFailure() { accounts=null;
 * Mockito.when(accountRepository.save(account)).thenReturn(accounts);
 * AccountOpeningDetails result=accountService.updateAccount(account);
 * assertEquals(null, result); verify(accountRepository).save(account); }
 * 
 * @Test public void testDeleteAccountByIdSuccess() { long id = 1;
 * Mockito.when(accountRepository.existsById(id)).thenReturn(true); boolean
 * result = accountService.deleteAccountById(id); assertTrue(result);
 * verify(accountRepository).existsById(id);
 * 
 * }
 * 
 * @Test public void testDeleteAccountByIdFailure() { long id = 1;
 * Mockito.when(accountRepository.existsById(id)).thenReturn(false); boolean
 * result = accountService.deleteAccountById(id); assertFalse(result);
 * verify(accountRepository).existsById(id); }
 * 
 * @Test public void testViewAccountsByTypeSuccess() throws JSONException {
 * ArrayList<AccountOpeningDetails> accountTypeList= new
 * ArrayList<AccountOpeningDetails>(); String accountType="Savings Account";
 * Mockito.when(accountRepository.viewAccountByType(accountType)).thenReturn(
 * accountTypeList); ArrayList<AccountOpeningDetails>
 * result=accountService.viewAccountsByType(accountType); String actual =
 * "{accountNo:1, accountName:\"John\", accountType:\"Savings Account\",accountBalance:10000}"
 * ; JSONAssert.assertEquals(
 * "{accountNo:1, accountName:\"John\", accountType:\"Savings Account\",accountBalance:10000}"
 * , actual, JSONCompareMode.STRICT); assertEquals(accountTypeList, result);
 * verify(accountRepository).viewAccountByType(accountType); }
 * 
 * @Test public void testViewAccountsByTypeFailure() {
 * ArrayList<AccountOpeningDetails> accountTypeList= null; String
 * accountType="Savings Account";
 * Mockito.when(accountRepository.viewAccountByType(accountType)).thenReturn(
 * accountTypeList); ArrayList<AccountOpeningDetails>
 * result=accountService.viewAccountsByType(accountType); assertEquals(null,
 * result); verify(accountRepository).viewAccountByType(accountType); }
 * 
 * @Test public void testViewAccountsByNameSuccess() throws JSONException {
 * ArrayList<AccountOpeningDetails> accountNameList= new
 * ArrayList<AccountOpeningDetails>(); String accountName="Arnav Nayak";
 * Mockito.when(accountRepository.viewAccountByName(accountName)).thenReturn(
 * accountNameList); ArrayList<AccountOpeningDetails>
 * result=accountService.viewAccountsByName(accountName); String actual =
 * "{accountNo:1, accountName:\"John\", accountType:\"Savings Account\",accountBalance:10000}"
 * ; JSONAssert.assertEquals(
 * "{accountNo:1, accountName:\"John\", accountType:\"Savings Account\",accountBalance:10000}"
 * , actual, JSONCompareMode.STRICT); assertEquals(accountNameList, result);
 * verify(accountRepository).viewAccountByName(accountName); }
 * 
 * @Test public void testViewAccountsByNameFailure() {
 * ArrayList<AccountOpeningDetails> accountNameList= null; String
 * accountName="Arnav Nayak";
 * Mockito.when(accountRepository.viewAccountByName(accountName)).thenReturn(
 * accountNameList); ArrayList<AccountOpeningDetails>
 * result=accountService.viewAccountsByName(accountName); assertEquals(null,
 * result); verify(accountRepository).viewAccountByName(accountName); }
 * 
 * @Test public void testGetAccountBalanceByIdAndTypeSuccessFirstCondition() {
 * Optional<AccountOpeningDetails> accounts = Optional.of(account);
 * 
 * String accountType="Savings Account"; long accountId = 1;
 * 
 * Mockito.when(accountRepository.findById(accountId)).thenReturn(accounts);
 * assertThat(accounts).isPresent();
 * 
 * accountService.getAccountBalanceByIdAndType(accountId,accountType);
 * verify(accountRepository).findById(accountId); }
 * 
 * @Test public void testGetAccountBalanceByIdAndTypeFailureFirstCondition()
 * throws JSONException { ArrayList<AccountOpeningDetails> accountTypeList= new
 * ArrayList<AccountOpeningDetails>(); long accountId = 1; String
 * accountType="Savings Account";
 * 
 * Mockito.when(accountRepository.viewAccountByType(accountType)).thenReturn(
 * accountTypeList);
 * accountService.getAccountBalanceByIdAndType(accountId,accountType);
 * accountService.viewAccountsByType(accountType);
 * verify(accountRepository).findById(accountId);
 * verify(accountRepository).viewAccountByType(accountType); }
 * 
 * }
 */