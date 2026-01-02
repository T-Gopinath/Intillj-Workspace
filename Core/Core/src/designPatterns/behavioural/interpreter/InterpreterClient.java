package designPatterns.behavioural.interpreter;

public class InterpreterClient {
    public static void main(String[] args) {

        // (5 + 3) - 2
        Expression five = new NumberExpression(5);
        Expression three = new NumberExpression(3);
        Expression two = new NumberExpression(2);

        Expression add = new AddExpression(five, three);
        Expression result = new SubtractExpression(add, two);

        System.out.println(result.interpret()); // Output: 6
    }
}


/**
 *
 * 5. Real-World Use Cases
 *
 * SQL query parsing
 *
 * Regular expression engines
 *
 * Rule engines
 *
 * Mathematical expression evaluators
 *
 * Configuration language parsers
 *
 * Spring Expression Language (SpEL)
 */

/**
 * 2. Key Components
 *
 * AbstractExpression
 *
 * Declares an interpret() method
 *
 * TerminalExpression
 *
 * Implements grammar rules for terminal symbols
 *
 * NonTerminalExpression
 *
 * Implements grammar rules for non-terminal symbols (AND, OR, ADD, SUBTRACT, etc.)
 *
 * Context
 *
 * Contains information required for interpretation
 *
 * Client
 *
 * Builds the expression tree and calls interpret()
 */