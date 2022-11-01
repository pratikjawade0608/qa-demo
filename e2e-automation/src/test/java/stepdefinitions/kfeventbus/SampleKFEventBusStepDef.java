package stepdefinitions.kfeventbus;

import io.cloudevents.CloudEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kfEventBus.CloudEventUtils;
import kfEventBus.KFEventAttributes;
import kfEventBus.KFEventBusClient;
import kfEventBus.KFEventBusClientManager;
import org.testng.Assert;
import reusable.KFHttpResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

public class SampleKFEventBusStepDef {

    private KFEventBusClient eventBusClient;
    private KFHttpResponse response;
    private String payload;

    @Given("A connection is stablished with KF Event Bus")
    public void a_connection_is_stablished_with_kf_event_bus() throws URISyntaxException {
        this.eventBusClient = KFEventBusClientManager.getKFEventBusClient();
    }

    @When("User sends a message to KF event bus")
    public void user_sends_a_message_to_kf_event_bus() throws IOException, InterruptedException {
        this.payload = "payload";
        this.response = this.eventBusClient.sendEvent(this.payload,"ic2-process", "qa-testing", URI.create("http://localhost:3000/test"), "qa-testing", new KFEventAttributes("1", 3, "1", "1", 1));
    }

    @Then("The message is processed successfully by KF event bus")
    public void the_message_is_processed_successfully_by_KF_event_bus() {
        Assert.assertNotEquals(this.response, null);
        Assert.assertEquals(this.response.getResponseCode(), 200);
    }

    @And("User waits for {int} seconds")
    public void user_waits_for_n_seconds(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @And("User can retrieve the message from KF Event bus")
    public void user_can_retrieve_the_message_from_KF_event_bus() throws URISyntaxException, IOException {
        Optional<CloudEvent> eventOptional = eventBusClient.getEvent("ic2-process", "test-ravens");
        String retrievedPayload = "";

        if(eventOptional.isPresent()){
            CloudEvent event = eventOptional.get();
            retrievedPayload = CloudEventUtils.getPayload(event, String.class);
        }

        Assert.assertTrue(eventOptional.isPresent());
        Assert.assertEquals(this.payload, retrievedPayload);
    }
}
