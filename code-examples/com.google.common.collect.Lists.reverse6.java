public void addSecurityRules ( final Rules rules, final IProgressMonitor monitor )
{
    if ( rules == null )
    {
        return;
    }

    int priority = 1000;

    monitor.beginTask ( "Encoding security rules", rules.getRules ().size () );

    for ( final Rule rule : Lists.reverse ( rules.getRules () ) )
    {
        final RuleEncoder encoder = RuleEncoder.findEncoder ( rule );
        if ( encoder != null )
        {
            encoder.encodeRule ( this.ctx, priority += 100 );
        }
        monitor.worked ( 1 );
    }

    monitor.done ();
}