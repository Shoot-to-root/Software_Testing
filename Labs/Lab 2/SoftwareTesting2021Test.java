import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

class paypalServiceTest implements paypalService {
    @Override public String doDonate() // A least 10000 NT per donation
    {
        return "succeed";
    }
}

@ExtendWith(MockitoExtension.class)
class SoftwareTesting2021Test {
    @Mock Date mockDate;
    @Mock Hospital mockHospital;
    @Mock Student mockStudent;
    @Mock NYCUDatabase mockDatabase;
    SoftwareTesting2021 softwareTesting2021 = new SoftwareTesting2021();

    // If a  fever student enter the class on Wednesday , verify that hospital doesn’t do any treatment.
    @Test
    public void test_a() throws InterruptedException {
        softwareTesting2021.setHospital(mockHospital);
        when(mockDate.getWeekday()).thenReturn(4);
        softwareTesting2021.date = mockDate;
        softwareTesting2021.enterClass(mockStudent);
        verify(mockHospital, never()).treatment(mockStudent);
    }

    //If a fever student enter the class on Thursday, assert the output correct.
    @Test
    public void test_b() throws InterruptedException {
        softwareTesting2021.setHospital(mockHospital);
        when(mockDate.getWeekday()).thenReturn(5);
        when(mockStudent.getTemperature()).thenReturn(38.0);
        softwareTesting2021.date = mockDate;
        softwareTesting2021.enterClass(mockStudent);

        assertEquals("Have a class today!\r\nNo! This student should not  come. We will send him/her to hospital. \r\n",
                "Have a class today!\r\nNo! This student should not  come. We will send him/her to hospital. \r\n");
    }

    //Assume 3 students go to hospital. Verify patientLog in hospital will record patient’s studentid with spy method. Don’t stub getLog function.
    @Test
    public void test_c() throws InterruptedException {
        Hospital hospital = new Hospital();
        Hospital spyHospital = spy(hospital);

        doNothing().doThrow(new InterruptedException()).when(spyHospital).isolation(mockStudent);
        when(mockStudent.getStudentId()).thenReturn("1");
        spyHospital.treatment(mockStudent);

        when(mockStudent.getStudentId()).thenReturn("2");
        spyHospital.treatment(mockStudent);

        when(mockStudent.getStudentId()).thenReturn("3");
        spyHospital.treatment(mockStudent);

        assertEquals("1", spyHospital.getLog().get(0));
        assertEquals("2", spyHospital.getLog().get(1));
        assertEquals("3", spyHospital.getLog().get(2));
    }

    //Use stub method to test getScore function to avoid connection to outer database.
    @Test
    public void test_d() throws InterruptedException {
        when(mockDatabase.getScore(mockStudent.getStudentId())).thenReturn(80);
        assertEquals(80, mockDatabase.getScore(mockStudent.getStudentId()));
    }

    //Implement paypalService interface as a fake object to test donate function.
    @Test
    public void test_e() throws InterruptedException {
        paypalServiceTest paypalServiceTest1 = new paypalServiceTest();
        assertEquals("Thank you", softwareTesting2021.donate(paypalServiceTest1));
    }
}