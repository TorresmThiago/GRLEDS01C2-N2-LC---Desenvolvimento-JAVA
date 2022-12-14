package br.edu.infnet.appseguranca.model.auxiliar;

public class Constantes {

    public final static int RISCO_ALTA = 1;
    public final static int RISCO_MEDIA = 2;
    public final static int RISCO_BAIXA = 3;

    public static final String SEVERIDADE_CRITICA = "Crítica";
    public static final String SEVERIDADE_ALTA = "Alta";
    public static final String SEVERIDADE_MEDIA = "Média";
    public static final String SEVERIDADE_BAIXA = "Baixa";

    public final static String NAVEGADOR_CHROME = "Chrome";
    public final static String NAVEGADOR_FIREFOX = "Firefox";
    public final static String NAVEGADOR_EDGE = "Edge";
    public final static String NAVEGADOR_OPERA = "Opera";
    public final static String NAVEGADOR_SAFARI = "Safari";
    public final static String NAVEGADOR_OUTROS = "Outros";

    public final static String SISTEMA_OPERACIONAL_MOBILE_ANDROID = "Android";
    public final static String SISTEMA_OPERACIONAL_MOBILE_IOS = "iOS";
    public final static String SISTEMA_OPERACIONAL_MOBILE_WINDOWS = "Windows";
    public final static String SISTEMA_OPERACIONAL_MOBILE_OUTROS = "Outros";

    public final static String CLASSIFICACAO_OWASP_A1 = "A1 - Falha no controle de acesso";
    public final static String CLASSIFICACAO_OWASP_A2 = "A2 - Falhas criptográficas";
    public final static String CLASSIFICACAO_OWASP_A3 = "A3 - Injeção";
    public final static String CLASSIFICACAO_OWASP_A4 = "A4 - Design inseguro";
    public final static String CLASSIFICACAO_OWASP_A5 = "A5 - Falha de configuração de segurança";
    public final static String CLASSIFICACAO_OWASP_A6 = "A6 - Componentes vulneráveis e desatualizados";
    public final static String CLASSIFICACAO_OWASP_A7 = "A7 - Falha de identificação e autenticação";
    public final static String CLASSIFICACAO_OWASP_A8 = "A8 - Falhas de software e integridade de dados";
    public final static String CLASSIFICACAO_OWASP_A9 = "A9 - Falhas de registro e monitoramento de segurança";
    public final static String CLASSIFICACAO_OWASP_A10 = "A10 - SSRF(Server Side Request Forgery)";
    public final static String[] CLASSIFICACAO_OWASP_CRITICA = { CLASSIFICACAO_OWASP_A1,
            CLASSIFICACAO_OWASP_A2, CLASSIFICACAO_OWASP_A3 };

    public final static String CLASSIFICACAO_OWASP_MOBILE_A1 = "A1 - Uso impróprio da plataforma";
    public final static String CLASSIFICACAO_OWASP_MOBILE_A2 = "A2 - Armazenamento de dados inseguro";
    public final static String CLASSIFICACAO_OWASP_MOBILE_A3 = "A3 - Comunicação insegura";
    public final static String CLASSIFICACAO_OWASP_MOBILE_A4 = "A4 - Autenticação insegura";
    public final static String CLASSIFICACAO_OWASP_MOBILE_A5 = "A5 - Criptografia insegura";
    public final static String CLASSIFICACAO_OWASP_MOBILE_A6 = "A6 - Autorização insegura";
    public final static String CLASSIFICACAO_OWASP_MOBILE_A7 = "A7 - Qualidade de código do cliente";
    public final static String CLASSIFICACAO_OWASP_MOBILE_A8 = "A8 - Alteração de código";
    public final static String CLASSIFICACAO_OWASP_MOBILE_A9 = "A9 - Engenharia reversa";
    public final static String CLASSIFICACAO_OWASP_MOBILE_A10 = "A10 - Funcionalidade alheia";
    public final static String[] CLASSIFICACAO_OWASP_MOBILE_CRITICA = { CLASSIFICACAO_OWASP_MOBILE_A1,
            CLASSIFICACAO_OWASP_MOBILE_A2, CLASSIFICACAO_OWASP_MOBILE_A3 };

    public final static String CLASSIFICACAO_OWASP_API_A1 = "A1 - Quebra do nivel de autorização de objeto";
    public final static String CLASSIFICACAO_OWASP_API_A2 = "A2 - Quebra de autenticação do usuário";
    public final static String CLASSIFICACAO_OWASP_API_A3 = "A3 - Exposição de dados exessivos";
    public final static String CLASSIFICACAO_OWASP_API_A4 = "A4 - Falta de recursos e limite de requisição";
    public final static String CLASSIFICACAO_OWASP_API_A5 = "A5 - Quebra de autorização do nível de função";
    public final static String CLASSIFICACAO_OWASP_API_A6 = "A6 - Atribuição em massa";
    public final static String CLASSIFICACAO_OWASP_API_A7 = "A7 - Má configuração de segurança";
    public final static String CLASSIFICACAO_OWASP_API_A8 = "A8 - Injeção";
    public final static String CLASSIFICACAO_OWASP_API_A9 = "A9 - Gerenciamento impróprio de ativos";
    public final static String CLASSIFICACAO_OWASP_API_A10 = "A10 - Log e monitoramento insuficientes";
    public final static String[] CLASSIFICACAO_OWASP_API_CRITICA = { CLASSIFICACAO_OWASP_API_A1,
            CLASSIFICACAO_OWASP_API_A2, CLASSIFICACAO_OWASP_API_A3 };

    public static final String[] METODOS_HTTP = { "GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS",
            "TRACE", "CONNECT" };

}
