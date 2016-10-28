package se.artheus.floyd4j;

import org.junit.Test;
import se.artheus.floyd4j.dependency.StringDependency;
import se.artheus.floyd4j.digraph.DependencyDigraph;
import se.artheus.floyd4j.digraph.DependencyEdge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CycleDetectorTest {

  private static final CycleDetector detector = new CycleDetector();

  @Test
  public void testSingleItemGraph() throws Exception {
    DependencyDigraph digraph = new DependencyDigraph(2);

    digraph.addEdge(
            new DependencyEdge(new StringDependency(0, "donut"), new StringDependency(1, "dough"))
    );

    assertFalse(detector.getDirectedCycle(digraph).hasCycle());
  }

  @Test
  public void testNonCyclicGraph() throws Exception {
    Dependency seed = new StringDependency("seed");
    Dependency sapling = new StringDependency("sapling");
    Dependency palm = new StringDependency("palm");
    Dependency coconut = new StringDependency("coconut");
    Dependency coconutMilk = new StringDependency("coconut milk");
    Dependency liqueur = new StringDependency("liqueur");
    Dependency pinaColada = new StringDependency("pina colada");

    DependencyDigraph digraph = new DependencyDigraph(
            new DependencyEdge(seed, sapling),
            new DependencyEdge(sapling, palm),
            new DependencyEdge(palm, coconut),
            new DependencyEdge(coconut, coconutMilk),

            new DependencyEdge(pinaColada, coconutMilk),
            new DependencyEdge(pinaColada, liqueur)
    );

    assertFalse(detector.getDirectedCycle(digraph).hasCycle());
  }

  @Test
  public void testCyclicGraph() throws Exception {
    StringDependency sea = new StringDependency("sea");
    StringDependency vapor = new StringDependency("vapor");
    StringDependency cloud = new StringDependency("cloud");
    StringDependency rain = new StringDependency("rain");

    DependencyDigraph digraph = new DependencyDigraph(
            new DependencyEdge(sea, vapor),
            new DependencyEdge(vapor, cloud),
            new DependencyEdge(cloud, rain),
            new DependencyEdge(rain, sea)
    );

    assertTrue(detector.getDirectedCycle(digraph).hasCycle());
  }

  @Test
  public void testComplexCyclicGraph() throws Exception {
    Dependency buy = new StringDependency("buy");
    Dependency checkout = new StringDependency("checkout");
    Dependency payment = new StringDependency("payment");
    Dependency customer = new StringDependency("customer");
    Dependency wallet = new StringDependency("wallet");
    Dependency money = new StringDependency("money");
    Dependency individual = new StringDependency("individual");
    Dependency employee = new StringDependency("employee");
    Dependency cashier = new StringDependency("cashier");
    Dependency cashRegister = new StringDependency("cash register");

    DependencyDigraph digraph = new DependencyDigraph(
            new DependencyEdge(individual, employee),
            new DependencyEdge(individual, customer),
            new DependencyEdge(employee, cashier),
            new DependencyEdge(customer, wallet),
            new DependencyEdge(wallet, money),
            new DependencyEdge(cashier, cashRegister),
            new DependencyEdge(cashRegister, money),
            new DependencyEdge(checkout, customer),
            new DependencyEdge(checkout, cashier),
            new DependencyEdge(payment, customer),
            new DependencyEdge(payment, money),
            new DependencyEdge(checkout, payment),
            new DependencyEdge(customer, buy),
            new DependencyEdge(buy, checkout)
    );

    assertTrue(detector.getDirectedCycle(digraph).hasCycle());
  }
}